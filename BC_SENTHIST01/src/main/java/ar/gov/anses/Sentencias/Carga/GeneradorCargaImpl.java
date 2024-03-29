package ar.gov.anses.Sentencias.Carga;


import ar.gov.anses.Sentencias.DTO.UsuarioDTO;
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
    public UsuarioDTO generarCarga(UsuarioDTO usuarioDTO) {
        try {
            return generadorCargaTramite.generarCarga(usuarioDTO);
        }catch (Exception e){
            logger.error("Error: en usuario " + usuarioDTO.getUsuarioRed());
            return usuarioDTO;
        }
    }
}
