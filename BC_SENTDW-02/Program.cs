using System;
using System.IO;
using PruebaBatch01.Batch;
using log4net.Config;
namespace PruebaBatch01
{
    class Program
    {
        static void Main(string[] args)
        {
            string logFilePath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "app.config");
            FileInfo finfo = new FileInfo(logFilePath);
            XmlConfigurator.Configure(finfo);
            new ProcesoBatch().ejecutarProceso();
        }
    }
}
