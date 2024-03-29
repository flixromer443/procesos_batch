package ar.gov.anses.Sentencias;

public class Constantes {

    /**
     * MODOS EJECUCION
     *
     * 1 = Generar archivo BAJADA_EDOCUMENTO.csv para los casos no procesados por BC_SENTDW01
     * 2 = Generar nuevo archivo BAJADA_EDOCUMENTO.csv con correccion del campo RUTA
     *
     * */

    public class ModosEjecucion{
        public static final int ARCHIVO_PARA_NO_PROCESADOS = 1;
        public static final int CORRECCION_CAMPOS = 2;
    }

    public class ModosEjecucionStr{
        public static final String ARCHIVO_PARA_NO_PROCESADOS = "ARCHIVO_PARA_NO_PROCESADOS";
        public static final String CORRECCION_CAMPOS = "CORRECCION_CAMPOS";
    }

    /**Campos de los archivos planos **/

    public static final String[] names = new String[]{"id","codigoSistema","tipoEDocumentoId","estadoEDocumentoId","entidad",
                                                      "preCuil","numeroDocumento","digitoVerificador","tipoTramite","secuencia",
                                                      "codigoExterno","metadata","titulo","descripcion","nombre","ruta","fechaIndexacionStr"};


    public static class Descripciones{
        public static final String TITULO_OPER3 = "Detalle de datos de la sentencia";
        public static final String TITULO_OPER4 = "Liquidacion de sentencia";
        public static final String TITULO_IG = "Liq.imp. a las ganancias y embargos";
    }

}
