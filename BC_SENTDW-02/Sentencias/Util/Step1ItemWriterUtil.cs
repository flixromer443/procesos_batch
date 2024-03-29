using System;
using System.Collections.Generic;
using System.IO;
using PruebaBatch01.Sentencias.DTO;
using log4net;
using Environment = PruebaBatch01.Config.Environment;

namespace PruebaBatch01.Sentencias.Util
{
    class Step1ItemWriterUtil
    {
        private static readonly ILog log = LogManager.GetLogger(typeof(Step1ItemWriterUtil));

        public static void escribirArchivo(List<EdocumentoOriginalDTO> elementos, string endPoint)
        {
            eliminarArchivoExistente(Environment.getProperty("carpetaRaiz") + endPoint);
            StreamWriter streamWriter = new StreamWriter(Environment.getProperty("carpetaRaiz") + endPoint);
            foreach (EdocumentoOriginalDTO elemento in elementos)
            {
                if (elemento.getId().Length > 0)
                {
                    streamWriter.WriteLine(elemento.getId().Trim());
                }
            }
            streamWriter.Close();
        }
        public static void eliminarArchivoExistente(string archivo)
        {
            if (File.Exists(archivo))
            {
                try
                {
                    File.Delete(archivo);
                }
                catch (Exception e)
                {
                    Console.WriteLine("Error al eliminar el archivo " + archivo + " : " + e);
                    log.Error("Error al eliminar el archivo " + archivo + " : " + e);
                }
            }
        }
    }
}
