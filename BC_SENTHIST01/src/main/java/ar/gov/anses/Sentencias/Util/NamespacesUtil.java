package ar.gov.anses.Sentencias.Util;

import org.springframework.core.io.FileSystemResource;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

/** Clase de utilidades provista para el proyecto **/

public class NamespacesUtil {

    public static Long toSentenciaId(String nombreArchivo){
        String[] miebros = nombreArchivo.split("_");
        String senteciaId = miebros[0];
        return Long.parseLong(senteciaId);
    }

    public static String completarConcCeros(int num, int ceros){
        String numero = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<= ceros; i ++){
            if(i == ceros){
                stringBuilder.append(numero);
            }else{
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();

    }


    public static Integer extraerSecuencia(String secuencia){
        return Integer.parseInt(secuencia.substring(22,23));
    }

    public static XMLGregorianCalendar obtenerFechaIndexacion() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(Calendar.getInstance().getTime());
        XMLGregorianCalendar XMLgc = null;
        try {
            XMLgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (DatatypeConfigurationException dce) {
            System.out.println("error al obtener fecha de indexacion");
        }
        return XMLgc;
    }

    public static XMLGregorianCalendar obtenerFechaIndexacion(String fecha) {

        String anioMesDia = fecha.substring(0,10);
        int anio = Integer.parseInt(anioMesDia.substring(0,4));
        int mes = Integer.parseInt(anioMesDia.substring(5,7));
        int dia = Integer.parseInt(anioMesDia.substring(8,10));

        String horaMinutoSegundo = fecha.substring(11,23);
        int hora = Integer.parseInt(horaMinutoSegundo.substring(0,2));
        int minuto = Integer.parseInt(horaMinutoSegundo.substring(3,5));
        int segundo = Integer.parseInt(horaMinutoSegundo.substring(6,8));
        int milisengundo = Integer.parseInt(horaMinutoSegundo.substring(9,12));


        GregorianCalendar c = new GregorianCalendar();
        XMLGregorianCalendar xmlGregorianCalendar = null;

        try {
            xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            xmlGregorianCalendar.setYear(anio);
            xmlGregorianCalendar.setMonth(mes);
            xmlGregorianCalendar.setDay(dia);
            xmlGregorianCalendar.setTime(hora,minuto,segundo,milisengundo);
        }catch (Exception e){
            System.out.println("error al obtener fecha de indexacion");
        }
        return xmlGregorianCalendar;
    }

    public static String obtenerUrl(String raiz,String endPoint){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(raiz);
        stringBuilder.append(endPoint);
        return stringBuilder.toString();
    }

    public static short extraerPrecuilDelExpediente(String expediente){
        return Short.parseShort(expediente.substring(3,5));
    }

    public static String extraerNumeroDocumentoDelExpediente(String expediente){
        return expediente.substring(5,13);
    }

    public static short extraerDigitoVerificadorDelExpediente(String expediente){
        return Short.parseShort(expediente.substring(13,14));
    }

    public static int extraerNumeroDeTramiteDelExpediente(String expediente){
        return Integer.parseInt(expediente.substring(14,17));
    }

    public static String determinarRuta(String ruta, String nombre){
        if(validarNuevoPath(ruta)){
            StringBuilder nuevoPath = new StringBuilder();
            nuevoPath.append(ruta);
            nuevoPath.append("\\");
            nuevoPath.append(nombre);
            return nuevoPath.toString();
        }else{
            return ruta;
        }

    }

    private static boolean validarNuevoPath(String ruta){
        String [] miembros = ruta.split("\\\\");
        if(miembros.length<10){
            return true;
        }
        return false;
    }

    public static String obtenerFechaIndexacionStr(Timestamp fecha){
        String fechaStr = fecha.toString();
        String[] tmpFechaCompleta = fechaStr.split(" ");
        String horaMinutoSegundo = tmpFechaCompleta[1];
        StringBuilder fechaCompletaNueva = new StringBuilder();
        fechaCompletaNueva.append(tmpFechaCompleta[0].trim());
        fechaCompletaNueva.append(" ");
        fechaCompletaNueva.append(completarMilisegundosConCeros(horaMinutoSegundo).trim());
        return fechaCompletaNueva.toString();
    }

    private static String completarMilisegundosConCeros(String horaMinutoSegundo){
        StringBuilder horaMinutoSegundoActualizado = new StringBuilder();
        horaMinutoSegundoActualizado.append(horaMinutoSegundo);
        while (horaMinutoSegundoActualizado.length()<12){
            horaMinutoSegundoActualizado.append("0");
        }
        return horaMinutoSegundoActualizado.toString();
    }

    public static FileSystemResource obtenerArchivo(String raiz, String endPoint){
        return new FileSystemResource(NamespacesUtil.obtenerUrl(raiz, endPoint));
    }
}
