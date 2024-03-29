package ar.gov.anses.Sentencias.Util;

import ar.gov.anses.Batch.step1.Step1ItemWriter;
import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.Constantes.Descripciones;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModoEjecucionUtil {

    public static List<String> obtenerIdsCasosNoProcesados(String carpetaRaiz) throws FileNotFoundException {
        File file = new File(carpetaRaiz + "/ENTRADA/NO_PROCESADOS.txt.1");
        Scanner scanner = new Scanner(file);
        List<String> casosNoProcesados = new ArrayList<>();
        while (scanner.hasNextLine()){
            casosNoProcesados.add(scanner.nextLine().trim());
        }
        return casosNoProcesados;
    }

    public static String obtenerNuevoPath(String ruta, String nombre){
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

    public static String obtenerModoEjecucionStr(String modoEjecucion){
        switch (Integer.parseInt(modoEjecucion)){
            case Constantes.ModosEjecucion.ARCHIVO_PARA_NO_PROCESADOS:
                return Constantes.ModosEjecucionStr.ARCHIVO_PARA_NO_PROCESADOS;
            case Constantes.ModosEjecucion.CORRECCION_CAMPOS:
                return Constantes.ModosEjecucionStr.CORRECCION_CAMPOS;
            default:
                return null;
        }
    }
    public static String determinarDescripcion(String nombreArchivo){
        switch (obtenerOper(nombreArchivo)){
            case "3": return Descripciones.TITULO_OPER3;
            case "4": return Descripciones.TITULO_OPER4;
            case "IG": return Descripciones.TITULO_IG;
            default: return "";
        }
    }

    private static String obtenerOper(String nombreArchivo){
        String[] nombreOperadorExtension = nombreArchivo.split("_");
        String operadorExtensionStr =  nombreOperadorExtension[1];
        return extraerOper(operadorExtensionStr);
    }
    private static String extraerOper(String operadorExtension){
        String operador = operadorExtension.substring(0,1);
        if(operador.equals("3") || operador.equals("4")){
            return operador;
        }else {
            return "IG";
        }
    }
}
