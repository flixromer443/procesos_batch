package ar.gov.anses.Batch.step1;

import ar.gov.anses.Sentencias.Carga.GeneradorCarga;
import ar.gov.anses.Sentencias.Constantes.Situaciones;
import ar.gov.anses.Sentencias.DTO.UsuarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


/** Clase que se encarga de correjir los edocumentos mal grabados mediante el webservice digiweb **/

public class Step1ItemProcessor implements ItemProcessor<UsuarioDTO, UsuarioDTO> {

    private Logger logger = LoggerFactory.getLogger(Step1ItemProcessor.class);

    @Autowired
    @Qualifier(value = "generadorCarga")
    private GeneradorCarga generadorCarga ;

    @Override
    public UsuarioDTO process(UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioActualizado = generadorCarga.generarCarga(usuarioDTO);

        if(usuarioActualizado.getSituacion() == Situaciones.ACTUALIZADO){
            logger.info("Los estados historicos del usuario ID " + usuarioDTO.getUsuarioRed() + " han sido actualizados exitosamente");
            usuarioDTO.setSituacion(Situaciones.ACTUALIZADO);
        }else {
            logger.error("Ha ocurrido un error al actualizar los estados historicos del usuario ID " + usuarioDTO.getUsuarioRed());
            usuarioDTO.setSituacion(Situaciones.NO_ACTUALIZADO);
        }
        return usuarioDTO;
    }

}
