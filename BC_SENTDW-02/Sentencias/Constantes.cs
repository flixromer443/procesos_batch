namespace PruebaBatch01.Sentencias
{
    class Constantes
    {
        /**
         * ESTADOS_PROCESO
         *
         * @NO_PROCESADOS
         * 0 = No procesado - estado inicial - (EL TRAMITE INVALIDO O NO SE VALIDO DURANTE LA GENERACION DE LA CARGA)
         * 1 = Carga generada(PASO TODAS LAS VALIDACIONES, SE ENVIO A DIGIWEB Y NO SE RECIBE RESPUESTA DEL SERVICIO)
         *
         * @PROCESADOS
         * 2 = Grabado en digiweb(SE GENERO LA CARGA, SE ENVIO AL SERVICIO Y ESTE DEVOLVIO UNA RESPUESTA)
         *
         * */
        
        public class Estados
        {
            public static readonly int NO_PROCESADO = 0;
            public static readonly int CARGA_GENERADA = 1;
            public static readonly int GRABADO_EN_DIGIWEB = 2;
        }

        public class Archivos
        {
            public static readonly string ENTRADA = "/BAJADA_EDOCUMENTO.csv";
            public static readonly string SALIDA_1 = "/PROCESADOS.txt";
            public static readonly string SALIDA_2 = "/NO_PROCESADOS.txt";
        }
    }
}
