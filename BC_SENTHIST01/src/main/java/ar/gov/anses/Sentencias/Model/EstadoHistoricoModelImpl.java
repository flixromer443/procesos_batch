package ar.gov.anses.Sentencias.Model;

import ar.gov.anses.Sentencias.DAO.EstadoHistoricoDaoImpl;
import ar.gov.anses.Sentencias.DTO.EstadoHistoricoDTO;
import ar.gov.anses.Sentencias.Domain.EstadoHistorico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoHistoricoModelImpl implements EstadoHistoricoModel {

    @Autowired
    private EstadoHistoricoDaoImpl estadoHistoricoDao;

    @Override
    public List<EstadoHistoricoDTO> findEstadosHistoricos12(){

        List<EstadoHistorico> estadoHistoricos = estadoHistoricoDao.findEstadosHistoricos12();
              /*.stream()
                .filter(c->!c.getUsuarioId().isEmpty() || c.getUsuarioId().trim().length()> 8)
                .collect(Collectors.toList());*/

        return new EstadoHistoricoDTO().mapToEstadoHistoricoDTO(estadoHistoricos);
    }

    @Override
    public void actualizarEstadoHistorico(List<EstadoHistoricoDTO> estadosHistoricos){
        estadoHistoricoDao.saveAll(new EstadoHistoricoDTO().mapFromEstadoHistoricoDTO(estadosHistoricos));
    }
}
