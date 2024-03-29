package ar.gov.anses.Sentencias.Carga;

import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GeneradorCargaImpl implements GeneradorCarga{

    private Logger logger =  LoggerFactory.getLogger(GeneradorCargaImpl.class);

    @Autowired @Qualifier("generadorCargaTramiteImpl")
    private GeneradorCargaTramite generadorCargaTramite;

    @Override
    public EDocumentoOriginalDTO generarCarga(EDocumentoOriginalDTO eDocumentoOriginalDTO) {
        try {
            return generadorCargaTramite.generarCarga(eDocumentoOriginalDTO);
        }catch (Exception e){
            logger.error("Error: al determinar el tipo de tramite " + eDocumentoOriginalDTO.getTipoTramite());
            return eDocumentoOriginalDTO;
        }
    }
}
