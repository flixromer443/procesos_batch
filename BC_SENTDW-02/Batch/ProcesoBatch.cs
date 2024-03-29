using System;
using System.Collections.Generic;
using PruebaBatch01.Batch.step1;
using PruebaBatch01.Sentencias.DTO;
using PruebaBatch01.Sentencias.Util;

namespace PruebaBatch01.Batch
{

    class ProcesoBatch
    {

        private Step1ItemReader step1ItemReader = new Step1ItemReader();
        private Step1ItemProccesor step1ItemProccesor = new Step1ItemProccesor();
        private Step1ItemWriter step1ItemWriter = new Step1ItemWriter();
        private List<EdocumentoOriginalDTO> edocumentos = new List<EdocumentoOriginalDTO>();

        public void ejecutarProceso()
        {

            DateTime inicio = Convert.ToDateTime(DateTime.Now);
            ProcesoBatchUtil.mostrarInicioEjecucion();

            step1(edocumentos);
            
            DateTime fin = Convert.ToDateTime(DateTime.Now);
            ProcesoBatchUtil.mostrarFinEjecucion();
            ProcesoBatchUtil.mostrarTiempoEjecucion(inicio, fin);
        }
        private void step1(List<EdocumentoOriginalDTO> edocumentos)
        {
            step1ItemReader.read(edocumentos);
            step1ItemProccesor.process(edocumentos);
            step1ItemWriter.write(edocumentos);
        }
        
    }
    
}
