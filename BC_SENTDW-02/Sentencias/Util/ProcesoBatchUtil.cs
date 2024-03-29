using System;
using PruebaBatch01.Batch;
using log4net;

namespace PruebaBatch01.Sentencias.Util
{
    class ProcesoBatchUtil
    {
        private static readonly ILog log = LogManager.GetLogger(typeof(ProcesoBatch));

        public static void mostrarInicioEjecucion()
        {
            string[] inicioStr = FechaUtil.obtenerFechaStr();
            Console.WriteLine("Inicio del job [REPROCESAR EDOCUMENTOS] Fecha: " + inicioStr[0] + " Hora: " + inicioStr[1]);
            log.Info("Inicio del job [REPROCESAR EDOCUMENTOS] Fecha: " + inicioStr[0] + " Hora: " + inicioStr[1]);
        }
        public static void mostrarFinEjecucion()
        {
            string[] finStr = FechaUtil.obtenerFechaStr();
            log.Info("Fin del job [REPROCESAR EDOCUMENTOS] Fecha: " + finStr[0] + " Hora: " + finStr[1]);
            Console.WriteLine("Fin del job [REPROCESAR EDOCUMENTOS] Fecha: " + finStr[0] + " Hora: " + finStr[1]);
        }
        public static void mostrarTiempoEjecucion(DateTime inicio, DateTime fin)
        {
            Console.WriteLine("Tiempo total transcurrido: " + FechaUtil.restarHoras(inicio, fin));
            log.Info("Tiempo total transcurrido: " + FechaUtil.restarHoras(inicio, fin));

        }
    }
}
