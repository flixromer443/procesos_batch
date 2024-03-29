using System;
using System.Collections.Generic;
using PruebaBatch01.Sentencias;
using PruebaBatch01.Sentencias.DTO;
using PruebaBatch01.Sentencias.Util;
using log4net;

namespace PruebaBatch01.Batch.step1
{
    class Step1ItemWriter
    {
        private static readonly ILog log = LogManager.GetLogger(typeof(Step1ItemWriter));

        List<EdocumentoOriginalDTO> procesados = new List<EdocumentoOriginalDTO>();
        List<EdocumentoOriginalDTO> noProcesados = new List<EdocumentoOriginalDTO>();

        public void write(List<EdocumentoOriginalDTO> edocumentos)
        {

            determinarGrupos(edocumentos);
            Console.WriteLine("Escribiendo " + procesados.Count + " edocumentos en el registro de elementos procesados");
            log.Info("Escribiendo " + procesados.Count + " edocumentos en el registro de elementos procesados");
            Step1ItemWriterUtil.escribirArchivo(procesados, Constantes.Archivos.SALIDA_1);

            Console.WriteLine("Escribiendo " + noProcesados.Count + " edocumentos en el registro de elementos no procesados");
            log.Info("Escribiendo " + noProcesados.Count + " edocumentos en el registro de elementos no procesados");
            Step1ItemWriterUtil.escribirArchivo(noProcesados, Constantes.Archivos.SALIDA_2);

        }

        private void determinarGrupos(List<EdocumentoOriginalDTO> edocumentos)
        {
            foreach(EdocumentoOriginalDTO edocumento in edocumentos)
            {
                if (edocumento.getEstadoProceso().Equals(Constantes.Estados.GRABADO_EN_DIGIWEB))
                {
                    procesados.Add(edocumento);
                }
                else
                {
                    noProcesados.Add(edocumento);
                }
            }
        }
        
    }
}
