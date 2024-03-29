package ar.gov.anses.Sentencias;


public class Constantes {

    public class Situaciones{
        public static final String ACTUALIZADO = "ACTUALIZADO";
        public static final String NO_ACTUALIZADO = "NO ACTUALIZADO";
    }

    /** Endpoints archivos de entrada y salida**/
    public static class CarpetasArchivos{
        public static final String ARCHIVO_ENTRADA = "/ENTRADA/ENTRADA.csv";
        public static final String ARCHIVO_SALIDA = "/SALIDA/SALIDA.csv";
    }

    /**Campos de los archivos planos **/
    public static class CamposArchivo{
        public static final String[] ENTRADA = new String[]{"usuarioRed","nombre","oficina"};
        public static final String[] SALIDA = new String[]{"usuarioRed","nombre","oficina","situacion"};
    }

}
