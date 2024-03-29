using System;
using System.Collections.Generic;
using PruebaBatch01.Sentencias;
using PruebaBatch01.Sentencias.DTO;
using PruebaBatch01.Sentencias.Carga;
using PruebaBatch01.Sentencias.Util;
using Environment = PruebaBatch01.Config.Environment;

namespace PruebaBatch01.Batch.step1
{
    class Step1ItemProccesor
    {
        private static readonly log4net.ILog logger = log4net.LogManager.GetLogger(typeof(Step1ItemProccesor));
        private static readonly int hilos = int.Parse(Environment.getProperty("hilos"));

        public void process(List<EdocumentoOriginalDTO> edocumentos)
        {
            int capacidadPorLote = ItemProccesorUtil.determinarCapacidadPorLote(hilos, edocumentos.Count);
            int indexEdocumento = 0;
            procesarLotes(edocumentos, capacidadPorLote, indexEdocumento);
        }

        private void procesarLotes(List<EdocumentoOriginalDTO> edocumentos, int capacidadPorLote, int indexEdocumento)
        {
            for (int i = 0; i < hilos; i++)
            {
                List<EdocumentoOriginalDTO> loteEdocumento = new List<EdocumentoOriginalDTO>();
                for (int x = 0; x < capacidadPorLote; x++)
                {
                    if (indexEdocumento <= edocumentos.Count - 1)
                    {

                        if (x != capacidadPorLote - 1)
                        {
                            loteEdocumento.Add(edocumentos[indexEdocumento]);
                            indexEdocumento++;
                        }
                        else
                        {
                            procesarLote(loteEdocumento);

                        }
                    }
                }
            }
        }

        private void procesarLote(List<EdocumentoOriginalDTO> loteEdocumento)
        {
            List<EdocumentoOriginalDTO> loteActualizado = new GeneradorCarga().generarCargaLote(loteEdocumento);
            for (int i=0; i < loteActualizado.Count; i++)
            {
                if (loteActualizado[i] != null && loteActualizado[i].getEstadoProceso() == Constantes.Estados.CARGA_GENERADA)
                {
                    Console.WriteLine("Grabando edocumento ID " + loteActualizado[i].getId() + "en DigiWeb");
                    logger.Info("Grabando edocumento ID " + loteActualizado[i].getId() + "en DigiWeb");
                    /**ACA DEBERIA ESTAR EL LLAMADO AL SERVICIO**/
                    loteEdocumento[i].setEstadoProceso(Constantes.Estados.GRABADO_EN_DIGIWEB);
                }
                else
                {
                    logger.Error("El edocumento ID " + loteActualizado[i].getId() + " ha sido rechazado");
                    Console.WriteLine("Error al generar la carga para el edocumento ID " + loteActualizado[i].getId());
                }
            }
        }

    }

}
