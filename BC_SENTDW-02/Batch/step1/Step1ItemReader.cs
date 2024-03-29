using System;
using System.IO;
using System.Collections.Generic;
using System.Text;
using PruebaBatch01.Sentencias.DTO;
using PruebaBatch01.Sentencias.Util;
using Environment = PruebaBatch01.Config.Environment;
using PruebaBatch01.Sentencias;

namespace PruebaBatch01.Batch.step1
{
    class Step1ItemReader
    {
        public void read(List<EdocumentoOriginalDTO> edocumentos)
        {
            string path = Environment.getProperty("carpetaRaiz") + Constantes.Archivos.ENTRADA;
            FileStream fileStream = new FileStream(path,FileMode.Open);
            StreamReader streamReader = new StreamReader(fileStream);
            string fila = "";
            while((fila = streamReader.ReadLine()) != null)
            {
                edocumentos.Add(NamespacesUtil.toEdocumentoOriginalDTO(fila));
            }
        }

       
    }
}
