package ar.gov.anses.Batch.step1;

import ar.gov.anses.Sentencias.Carga.GeneradorCarga;
import ar.gov.anses.DigiWeb.WS.digitalizacionWSClient.DigitalizacionWSCLient;
import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import ar.gov.anses.Sentencias.Util.NamespacesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


/** Clase que se encarga de correjir los edocumentos mal grabados mediante el webservice digiweb **/

public class Step1ItemProcessor implements ItemProcessor<EDocumentoOriginalDTO, EDocumentoOriginalDTO> {

    private Logger logger = LoggerFactory.getLogger(Step1ItemProcessor.class);

    @Autowired
    @Qualifier(value = "generadorCarga")
    private GeneradorCarga generadorCarga ;

    @Autowired
    private DigitalizacionWSCLient digitalizacionService;

    @Override
    public EDocumentoOriginalDTO process(EDocumentoOriginalDTO eDocumentoOriginalDTO){
        logger.info("Ingresando el edocumento ID " + eDocumentoOriginalDTO.getId());
        EDocumentoOriginalDTO edocumendoNuevoDTO = generadorCarga.generarCarga(eDocumentoOriginalDTO);
        eDocumentoOriginalDTO.setFechaIndexacion(NamespacesUtil.obtenerFechaIndexacion(eDocumentoOriginalDTO.getFechaIndexacionStr()));

        if(edocumendoNuevoDTO.getEstadoProceso() == Constantes.CARGA_GENERADA){
            try {
                logger.info("Grabando el edocumento ID " + eDocumentoOriginalDTO.getId() + " en digiweb ");
                //digitalizacionService.actualizarEDocumentoV2(eDocumentoOriginalDTO);
                //logger.info("El edocumento ID " + eDocumentoOriginalDTO.getId() + " ha sido grabado exitosamente ");
                eDocumentoOriginalDTO.setEstadoProceso(Constantes.GRABADO_EN_DIGIWEB);
            }catch (Exception e){
                logger.error("Error al grabar edocumento ID " + eDocumentoOriginalDTO.getId() + " en digiweb");
                eDocumentoOriginalDTO.setEstadoProceso(Constantes.NO_PROCESADO);
            }
        }
        return eDocumentoOriginalDTO;
    }

}
