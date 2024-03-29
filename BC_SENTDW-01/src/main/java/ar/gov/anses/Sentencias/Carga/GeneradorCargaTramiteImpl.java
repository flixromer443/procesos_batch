package ar.gov.anses.Sentencias.Carga;

import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import ar.gov.anses.Sentencias.DTO.CuilDTO;
import ar.gov.anses.Sentencias.DTO.SentenciaDTO;
import ar.gov.anses.Sentencias.Model.SentenciasModel;
import ar.gov.anses.Sentencias.Util.NamespacesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneradorCargaTramiteImpl implements GeneradorCargaTramite {

    private Logger logger =  LoggerFactory.getLogger(GeneradorCargaTramiteImpl.class);

    @Autowired
    private SentenciasModel sentenciasModel;

    @Override
    public EDocumentoOriginalDTO generarCarga(EDocumentoOriginalDTO eDocumentoOriginalDTO) {
        try {
            if(validarEdocumento(eDocumentoOriginalDTO)){
                return regenerarEdocumento(eDocumentoOriginalDTO);
            }else{
                return eDocumentoOriginalDTO;
            }
        }catch (Exception e){
            logger.error("Error al generar la carga para el edocumento ID " + eDocumentoOriginalDTO.getId());
            logger.error("Error: " + e.getMessage());
            logger.error(e.getStackTrace().toString());
            return null;
        }
    }

    /**Valido que el expediente administrativo coincida con los siguientes campos del edocumento
     * @Entidad
     * @Precuil
     * @NumeroDocumento
     * @DigitoVerificador
     * @TipoTramite
     * */
    private Boolean validarEdocumento(EDocumentoOriginalDTO eDocumentoOriginalDTO){
        try{
            logger.info("Validando el edocumento ID " + eDocumentoOriginalDTO.getId());

            Long sentenciaId = NamespacesUtil.toSentenciaId(eDocumentoOriginalDTO.getNombre());
            SentenciaDTO sentencia = sentenciasModel.findSentenciasById(sentenciaId);
            String expedienteSinSecuenciaSentencias = NamespacesUtil.toExpedienteSinSecuencia(sentencia.getExpedienteAdministrativo());

            String entidad = eDocumentoOriginalDTO.getEntidad();
            CuilDTO cuilDTO = NamespacesUtil.generarCuil(eDocumentoOriginalDTO);
            Integer tipotramite = eDocumentoOriginalDTO.getTipoTramite();

            String expedienteSinSecuenciaDigiweb = NamespacesUtil.toExpedienteSinSecuencia(entidad,cuilDTO,tipotramite);

            if(expedienteSinSecuenciaDigiweb.equals(expedienteSinSecuenciaSentencias)){
                eDocumentoOriginalDTO.setTmpExpedienteAdministrativo(sentencia.getExpedienteAdministrativo());
                logger.info("El edocumento ID " + eDocumentoOriginalDTO.getId() + " ha sido validado exitosamente");
                return true;
            }else {
                logger.warn("El edocumento ID " + eDocumentoOriginalDTO.getId() + " no coincide con el expediente de sentencias");

                if (reacondicionarEdocumento(eDocumentoOriginalDTO, expedienteSinSecuenciaSentencias)) {
                    eDocumentoOriginalDTO.setTmpExpedienteAdministrativo(sentencia.getExpedienteAdministrativo());
                    logger.info("El edocumento ID " + eDocumentoOriginalDTO.getId() + " ha sido validado exitosamente");
                    return true;
                }else{
                    logger.warn("El edocumento ID " + eDocumentoOriginalDTO.getId() + " no es valido para reprocesar");
                    return false;
                }
            }

        }catch (Exception e){
            logger.error("No se ha encontrado una sentencia para el edocumento ID " + eDocumentoOriginalDTO.getId());
            return false;
        }
    }

    /**Seteo el numero de secuencia sacado del expediente **/
    private EDocumentoOriginalDTO regenerarEdocumento(EDocumentoOriginalDTO eDocumentoOriginalDTO){
        try{
            String expedienteAdministrativo = eDocumentoOriginalDTO.getTmpExpedienteAdministrativo();
            eDocumentoOriginalDTO.setSecuencia(NamespacesUtil.extraerSecuencia(expedienteAdministrativo));
            eDocumentoOriginalDTO.setEstadoProceso(Constantes.CARGA_GENERADA);
            return eDocumentoOriginalDTO;
        }catch (Exception e){
            logger.error("Ha ocurrido un error durante la regeneracion del edocumento ID" + eDocumentoOriginalDTO.getId());
            return eDocumentoOriginalDTO;
        }
    }

    /**Seteo el numero de cuil sacado del expediente de sentencias**/
    private boolean reacondicionarEdocumento(EDocumentoOriginalDTO eDocumentoOriginalDTO, String expedienteSinSecuenciaSentencias){

        try{
            logger.info("Reacondicionando el edocumento ID " + eDocumentoOriginalDTO.getId() + " para revalidar");

            eDocumentoOriginalDTO.setPreCuil(NamespacesUtil.extraerPrecuilDelExpediente(expedienteSinSecuenciaSentencias));
            eDocumentoOriginalDTO.setNumeroDocumento(NamespacesUtil.extraerNumeroDocumentoDelExpediente(expedienteSinSecuenciaSentencias));
            eDocumentoOriginalDTO.setDigitoVerificador(NamespacesUtil.extraerDigitoVerificadorDelExpediente(expedienteSinSecuenciaSentencias));
            eDocumentoOriginalDTO.setTipoTramite(determinarTipoDeTramite(eDocumentoOriginalDTO,expedienteSinSecuenciaSentencias));

            String entidad = eDocumentoOriginalDTO.getEntidad();
            CuilDTO cuilExpedienteSentencias = NamespacesUtil.generarCuil(eDocumentoOriginalDTO);
            Integer tipoTramite = eDocumentoOriginalDTO.getTipoTramite();

            String nuevoExpedienteSinSecuenciaDigiweb = NamespacesUtil.toExpedienteSinSecuencia(entidad, cuilExpedienteSentencias, tipoTramite);

            if(nuevoExpedienteSinSecuenciaDigiweb.equals(expedienteSinSecuenciaSentencias)){
                logger.info("El CUIL del edocumento ID " + eDocumentoOriginalDTO.getId() + " ha sido reemplazado por CUIL del expediente de sentencias");
                return true;
            }else{
                logger.error("El edocumento ID " + eDocumentoOriginalDTO.getId() + " no ha podido ser reacondicionado");
                logger.error("El edocumento ID " + eDocumentoOriginalDTO.getId() + " no se encuentra asociado al titular y/o al causante de la sentencia");
                return false;
            }

        }catch (Exception e){
            logger.error("Ha ocurrido un error durante el reacondicionamiento del edocumento ID" + eDocumentoOriginalDTO.getId());
            return false;
        }

    }

    private int determinarTipoDeTramite(EDocumentoOriginalDTO edocumento, String expedienteSinSecuenciaSentencias){
        if(edocumento.getTipoTramite() == 232){
            Integer nuevoTipoDeTramite = NamespacesUtil.extraerNumeroDeTramiteDelExpediente(expedienteSinSecuenciaSentencias);
            logger.info("El tipo de tramite del edocumento ID " + edocumento.getId() + " ha sido actualizado");
            return nuevoTipoDeTramite;
        }
        return edocumento.getTipoTramite();
    }

}
