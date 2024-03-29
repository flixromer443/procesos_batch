package ar.gov.anses.Sentencias.Ejecucion;

import ar.gov.anses.Batch.step1.Step1ItemWriter;
import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import ar.gov.anses.Sentencias.Util.ModoEjecucionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ModoEjecucionImpl implements ModoEjecucion{

    private Logger logger =  LoggerFactory.getLogger(ModoEjecucionImpl.class);

    @Autowired
    private Environment environment;

    @Override
    public List<EDocumentoOriginalDTO> ejecutar(List<? extends EDocumentoOriginalDTO> edocumentos, String modoEjecucion) {
        try {
            return determinarModo(edocumentos,modoEjecucion);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<EDocumentoOriginalDTO> determinarModo(List<? extends EDocumentoOriginalDTO> edocumentos, String modoEjecucion) throws FileNotFoundException {
        switch (Integer.parseInt(modoEjecucion)){
            case Constantes.ModosEjecucion.ARCHIVO_PARA_NO_PROCESADOS:
                return modoArchivoParaNoProcesados(edocumentos);
            case Constantes.ModosEjecucion.CORRECCION_CAMPOS:
                return modoCorreccionCampos(edocumentos);
            default:
                return null;
        }
    }

    private List<EDocumentoOriginalDTO> modoArchivoParaNoProcesados(List<? extends EDocumentoOriginalDTO> edocumentos) throws FileNotFoundException {
        String carpetaRaiz = environment.getProperty("carpeta.raiz");
        List<EDocumentoOriginalDTO> casosNoProcesados = new ArrayList<>();
        List<String> idsCasosNoProcesados =  ModoEjecucionUtil.obtenerIdsCasosNoProcesados(carpetaRaiz);

        for (EDocumentoOriginalDTO eDocumento: edocumentos){
            for (String idCasoNoProcesado : idsCasosNoProcesados ){
                if(idCasoNoProcesado.equals(eDocumento.getId())){
                    logger.info(idCasoNoProcesado + " ES VALIDO");
                    casosNoProcesados.add(eDocumento);
                }
            }
        }
        return casosNoProcesados;
    }

    private List<EDocumentoOriginalDTO> modoCorreccionCampos(List<? extends EDocumentoOriginalDTO> edocumentos) throws FileNotFoundException {
        List<EDocumentoOriginalDTO> casosReacondicionados = new ArrayList<>();
        for (EDocumentoOriginalDTO eDocumento: edocumentos){
            eDocumento.setTitulo("SICASENT");
            eDocumento.setDescripcion(ModoEjecucionUtil.determinarDescripcion(eDocumento.getNombre()));
            eDocumento.setRuta(ModoEjecucionUtil.obtenerNuevoPath(eDocumento.getRuta(), eDocumento.getNombre()));
            casosReacondicionados.add(eDocumento);
        }
        return casosReacondicionados;
    }
}
