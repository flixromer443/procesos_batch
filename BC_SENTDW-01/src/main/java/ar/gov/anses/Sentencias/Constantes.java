package ar.gov.anses.Sentencias;

public class Constantes {
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

    public static final int NO_PROCESADO = 0;
    public static final int CARGA_GENERADA = 1;
    public static final int GRABADO_EN_DIGIWEB = 2;
    public static final String ESTADO_0 = "NO_PROCESADO";
    public static final String ESTADO_1 = "CARGA_GENERADA";
    public static final String ESTADO_2 = "GRABADO_EN_DIGIWEB";


    /**Campos de los archivos planos **/

    public static final String[] namesReader1 = new String[]{"id","codigoSistema","tipoEDocumentoId","estadoEDocumentoId","entidad",
                                                             "preCuil","numeroDocumento","digitoVerificador","tipoTramite","secuencia",
                                                             "codigoExterno","metadata","titulo","descripcion","nombre","ruta","fechaIndexacionStr"};


    public static final String[] names = new String[]{"id","estadoProceso"};

    public static final String[] namesFinalWriters = new String[]{"id"};

}
