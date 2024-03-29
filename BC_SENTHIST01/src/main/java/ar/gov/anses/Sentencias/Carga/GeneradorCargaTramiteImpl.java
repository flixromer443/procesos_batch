package ar.gov.anses.Sentencias.Carga;


import ar.gov.anses.Sentencias.Constantes.Situaciones;
import ar.gov.anses.Sentencias.DTO.*;
import ar.gov.anses.Sentencias.Model.EstadoHistoricoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneradorCargaTramiteImpl implements GeneradorCargaTramite {

    private Logger logger =  LoggerFactory.getLogger(GeneradorCargaTramiteImpl.class);

    @Autowired
    private EstadoHistoricoModel estadoHistoricoModel;

    @Override
    public UsuarioDTO generarCarga(UsuarioDTO usuarioDTO) {
        try {
            return regenerarEstadoHistorico(usuarioDTO);
        }catch (Exception e){
            logger.error("Error al generar la carga para el usuario ID " + usuarioDTO.getUsuarioRed());
            logger.error("Error: " + e.getMessage());
            logger.error(e.getStackTrace().toString());
            return null;
        }
    }


    private UsuarioDTO regenerarEstadoHistorico(UsuarioDTO usuarioDTO){
        try{
            logger.info("Validando el usuario ID " + usuarioDTO.getUsuarioRed());

            List<EstadoHistoricoDTO> estadosHistoricosUsuario = estadoHistoricoModel.findEstadosHistoricos12()
              .stream()
              .filter(e->e.getUsuarioId().trim().equals(usuarioDTO.getNombre().trim()))
              .collect(Collectors.toList());

            if(!estadosHistoricosUsuario.isEmpty()){
                for (EstadoHistoricoDTO estadoHistorico : estadosHistoricosUsuario){
                    estadoHistorico.setUsuarioId(usuarioDTO.getUsuarioRed());
                }
                //estadoHistoricoModel.actualizarEstadoHistorico(estadosHistoricosUsuario);
                logger.info("Se han actualizado " + estadosHistoricosUsuario.size() + " estados historicos para el usuario ID " + usuarioDTO.getUsuarioRed());
                usuarioDTO.setSituacion(Situaciones.ACTUALIZADO);
            }else {
                usuarioDTO.setSituacion(Situaciones.NO_ACTUALIZADO);
            }

        }catch (Exception e){
            logger.error("No se ha encontrado un estado historico para el usuario ID " + usuarioDTO.getUsuarioRed());
            usuarioDTO.setSituacion(Situaciones.NO_ACTUALIZADO);
        }
        return usuarioDTO;
    }




}
