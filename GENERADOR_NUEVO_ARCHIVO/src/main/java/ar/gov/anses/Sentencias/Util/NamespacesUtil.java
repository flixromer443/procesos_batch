package ar.gov.anses.Sentencias.Util;

import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import ar.gov.anses.Sentencias.DTO.CuilDTO;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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

    public static String toExpedienteAdministrativo(String entidad, CuilDTO cuilDTO, String tramite, int secuencia){
        StringBuilder expedienteAdministrativo = new StringBuilder();
        expedienteAdministrativo.append(entidad);
        expedienteAdministrativo.append(cuilDTO.getCuil());
        expedienteAdministrativo.append(tramite);
        expedienteAdministrativo.append(completarConcCeros(secuencia, 5));
        return expedienteAdministrativo.toString();
    }

    public static String toExpedienteSinSecuencia(String entidad, CuilDTO cuilDTO, Integer tramite){
        StringBuilder expedienteAdministrativo = new StringBuilder();
        expedienteAdministrativo.append(entidad);
        expedienteAdministrativo.append(cuilDTO.getCuil());
        expedienteAdministrativo.append(tramite.toString());
        return expedienteAdministrativo.toString();
    }
    public static String toExpedienteSinSecuencia(String expediente){
        return expediente.substring(0,17) ;
    }

    public static CuilDTO generarCuil(EDocumentoOriginalDTO eDocumentoOriginalDTO){
        Short precuil = eDocumentoOriginalDTO.getPreCuil();
        String numeroDocumento = eDocumentoOriginalDTO.getNumeroDocumento();
        Short digitoVerificador = eDocumentoOriginalDTO.getDigitoVerificador();
        return new CuilDTO(precuil.toString(),numeroDocumento,digitoVerificador.toString());
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
}
