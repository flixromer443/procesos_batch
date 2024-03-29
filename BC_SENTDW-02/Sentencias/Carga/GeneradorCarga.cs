using PruebaBatch01.Sentencias.Model;
using PruebaBatch01.Sentencias.DTO;
using PruebaBatch01.Sentencias.Util;
using System;
using System.Collections.Generic;

namespace PruebaBatch01.Sentencias.Carga
{
    class GeneradorCarga
    {
        private static readonly log4net.ILog logger = log4net.LogManager.GetLogger(typeof(GeneradorCarga)); 
        private SentenciasModelImpl sentenciasModel = new SentenciasModelImpl();

        public List<EdocumentoOriginalDTO> generarCargaLote(List<EdocumentoOriginalDTO> eDocumentos)
        {
            List<EdocumentoOriginalDTO> eDocumentosActualizados = new List<EdocumentoOriginalDTO>();
            List<SentenciaDTO> sentencias = sentenciasModel.findSentenciasByIds(GeneradorCargaUtil.extraerIdsSentencias(eDocumentos));
            
            foreach(EdocumentoOriginalDTO eDocumento in eDocumentos)
            {
                validarEdocumento(eDocumento, sentencias, eDocumentosActualizados);
            }

            return eDocumentosActualizados;
        }
        
        private void validarEdocumento(EdocumentoOriginalDTO eDocumento, List<SentenciaDTO> sentencias, List<EdocumentoOriginalDTO> eDocumentosActualizados)
        {
            Console.WriteLine("Validando el edocumento ID " + eDocumento.getId());
            logger.Info("Validando el edocumento ID " + eDocumento.getId());

            long sentenciaId = NamespacesUtil.toSentenciaId(eDocumento.getNombre());
            SentenciaDTO sentencia = GeneradorCargaUtil.buscarSentenciaPorId(sentenciaId, sentencias);
            if (sentencia.getExpedienteAdministrativo() != null)
            {

                if (compararExpedientes(eDocumento, sentencia.getExpedienteAdministrativo()))
                {
                    Console.WriteLine("El edocumento ID " + eDocumento.getId() + " ha sido validado exitosamente");
                    logger.Info("El edocumento ID " + eDocumento.getId() + " ha sido validado exitosamente");
                    regenerarEdocumento(eDocumento);
                }
                else
                {
                    Console.WriteLine("El expediente de la sentencia no coincide con el edocumento ID " + eDocumento.getId());
                    logger.Warn("El expediente de la sentencia no coincide con el edocumento ID " + eDocumento.getId());
                }
            }
            else
            {
                Console.WriteLine("No se ha encontrado una sentencia para el edocumento ID " + eDocumento.getId());
                logger.Error("No se ha encontrado una sentencia para el edocumento ID " + eDocumento.getId());
            }

            eDocumentosActualizados.Add(eDocumento);
        }

        private bool compararExpedientes(EdocumentoOriginalDTO eDocumentoOriginalDTO, string expedienteSentencia)
        {
            string expedienteSinSecuenciaSentencias = GeneradorCargaUtil.generarExpedienteSinSecuencia(expedienteSentencia);
            string expedienteSinSecuenciaDigiWeb = GeneradorCargaUtil.generarExpedienteSinSecuencia(eDocumentoOriginalDTO);

            if (expedienteSinSecuenciaDigiWeb.Equals(expedienteSinSecuenciaSentencias))
            {
                eDocumentoOriginalDTO.setTmpExpedienteAdministrativo(expedienteSentencia);
                return true;
            }
            else
            {
                Console.WriteLine("El edocumento ID " + eDocumentoOriginalDTO.getId() + " no es valido para reprocesar");
                logger.Warn("El edocumento ID " + eDocumentoOriginalDTO.getId() + " no es valido para reprocesar");
                return false;
            }
        }

        /**Seteo el numero de secuencia sacado del expediente **/
        private EdocumentoOriginalDTO regenerarEdocumento(EdocumentoOriginalDTO eDocumentoOriginalDTO)
        {
            string expedienteAdministrativo = eDocumentoOriginalDTO.getTmpExpedienteAdministrativo();
            eDocumentoOriginalDTO.setSecuencia(NamespacesUtil.extraerSecuencia(expedienteAdministrativo));
            eDocumentoOriginalDTO.setEstadoProceso(Constantes.Estados.CARGA_GENERADA);
            return eDocumentoOriginalDTO;
        }
    }
}
