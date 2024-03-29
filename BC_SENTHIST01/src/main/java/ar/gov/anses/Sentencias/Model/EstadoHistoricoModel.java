package ar.gov.anses.Sentencias.Model;

import ar.gov.anses.Sentencias.DTO.EstadoHistoricoDTO;

import java.util.List;

public interface EstadoHistoricoModel {

    public List<EstadoHistoricoDTO> findEstadosHistoricos12();
    public void actualizarEstadoHistorico(List<EstadoHistoricoDTO> estadosHistoricos);

}
