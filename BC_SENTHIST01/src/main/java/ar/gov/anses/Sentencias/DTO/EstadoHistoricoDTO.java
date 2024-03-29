package ar.gov.anses.Sentencias.DTO;

import ar.gov.anses.Sentencias.Domain.EstadoHistorico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstadoHistoricoDTO {

    private Long id;
    private Long sentenciaId;
    private Date FEstado;
    private String usuarioId;
    private Integer estadoCod;

    /** default constructor */
    public EstadoHistoricoDTO() {
    }


    // Property accessors
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSentenciaId() {
        return this.sentenciaId;
    }

    public void setSentenciaId(Long sentnciaId) {
        this.sentenciaId = sentnciaId;
    }

    public Date getFEstado() {
        return this.FEstado;
    }

    public void setFEstado(Date FEstado) {
        this.FEstado = FEstado;
    }

    public String getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getEstadoCod() {
        return estadoCod;
    }

    public void setEstadoCod(Integer estadoCod) {
        this.estadoCod = estadoCod;
    }

    public EstadoHistoricoDTO mapToEstadoHistoricoDTO(EstadoHistorico estadoHistorico){
        EstadoHistoricoDTO estadoHistoricoDTO= new EstadoHistoricoDTO();
        estadoHistoricoDTO.setId(estadoHistorico.getId());
        estadoHistoricoDTO.setSentenciaId(estadoHistorico.getSentenciaId());
        estadoHistoricoDTO.setFEstado(estadoHistorico.getFEstado());

        if(estadoHistorico.getUsuarioId() == null || estadoHistorico.getUsuarioId().isEmpty()){
            estadoHistoricoDTO.setUsuarioId("");
        }else {
            estadoHistoricoDTO.setUsuarioId(estadoHistorico.getUsuarioId());
        }

        estadoHistoricoDTO.setEstadoCod(estadoHistorico.getEstadoCod());
        return estadoHistoricoDTO;
    }

    public List<EstadoHistoricoDTO> mapToEstadoHistoricoDTO(List<EstadoHistorico> estadosHistoricos){
        List<EstadoHistoricoDTO> estadosHistoricosDTO= new ArrayList<>();

        for(EstadoHistorico estadoHistorico : estadosHistoricos){
           EstadoHistoricoDTO estadoHistoricoDTO = mapToEstadoHistoricoDTO(estadoHistorico);
           estadosHistoricosDTO.add(estadoHistoricoDTO);
        }
        return estadosHistoricosDTO;
    }


    public EstadoHistorico mapFromEstadoHistoricoDTO(EstadoHistoricoDTO estadoHistoricoDTO){
        EstadoHistorico estadoHistorico = new EstadoHistorico();
        estadoHistorico.setId(estadoHistoricoDTO.getId());
        estadoHistorico.setSentenciaId(estadoHistoricoDTO.getSentenciaId());
        estadoHistorico.setFEstado(estadoHistoricoDTO.getFEstado());
        estadoHistorico.setUsuarioId(estadoHistoricoDTO.getUsuarioId());
        estadoHistorico.setEstadoCod(estadoHistoricoDTO.getEstadoCod());
        return estadoHistorico;
    }


    public List<EstadoHistorico> mapFromEstadoHistoricoDTO(List<EstadoHistoricoDTO> estadosHistoricosDTO){
        List<EstadoHistorico> estadosHistoricos= new ArrayList<>();

        for(EstadoHistoricoDTO estadoHistoricoDTO : estadosHistoricosDTO){
            EstadoHistorico estadoHistorico = mapFromEstadoHistoricoDTO(estadoHistoricoDTO);
            estadosHistoricos.add(estadoHistorico);
        }
        return estadosHistoricos;
    }

}
