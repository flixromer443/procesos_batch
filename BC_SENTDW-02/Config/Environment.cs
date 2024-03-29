using System.Configuration;
using Microsoft.Data.SqlClient;

namespace PruebaBatch01.Config
{
    class Environment
    {
        public static string getProperty(string property)
        {
            switch (property)
            {
                case "digitalizacionWS": return ConfigurationManager.AppSettings["DigitalizacionWS"];
                case "servidorNas": return ConfigurationManager.AppSettings["ServidorNAS"];
                case "carpetaRaiz": return ConfigurationManager.AppSettings["CarpetaRaiz"];
                case "hilos": return ConfigurationManager.AppSettings["Hilos"];
                default: return null;
            }
        }
        public static SqlConnection getSicasentDatasource()
        {
            return new SqlConnection(ConfigurationManager.ConnectionStrings["SicasentDatasource"].ConnectionString);
        } 
    }
}
