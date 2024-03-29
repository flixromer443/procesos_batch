using System;
using System.Text;

namespace PruebaBatch01.Sentencias.Util
{
    class FechaUtil
    {
        public static string[] obtenerFechaStr()
        {
            DateTime now= Convert.ToDateTime(DateTime.Now);
            string[] fecha = new string[2]; 
            fecha[0] = now.Day + "/" + now.Month + "/" + now.Year;
            fecha[1] = now.Hour + ":" + now.Minute;
            return fecha;
        }
        public static string restarHoras(DateTime horaInicio, DateTime horaFin)
        {
            StringBuilder stringBuilder = new StringBuilder();
            int hora = horaFin.Hour - horaInicio.Hour;
            int segundos;
            if (horaFin.Second > horaInicio.Second)
            {
                segundos = horaFin.Second - horaInicio.Second;

            }
            else
            {
                segundos = horaInicio.Second - horaFin.Second;

            }
            int minutos;
            if (horaFin.Minute > horaInicio.Minute)
            {
                minutos = horaFin.Minute - horaInicio.Minute;

            }
            else
            {
                minutos = horaInicio.Minute - horaFin.Minute;

            }

            stringBuilder.Append(completarConCeros(hora));
            stringBuilder.Append(":");
            stringBuilder.Append(completarConCeros(minutos));
            stringBuilder.Append(":");
            stringBuilder.Append(completarConCeros(segundos));

            return stringBuilder.ToString();

        }
        private static string completarConCeros(int numero)
        {
            string num = numero.ToString();
            if (num.Length == 1)
            {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.Append("0");
                stringBuilder.Append(num);
                return stringBuilder.ToString();
            }
            return num;
        }
    }
}
