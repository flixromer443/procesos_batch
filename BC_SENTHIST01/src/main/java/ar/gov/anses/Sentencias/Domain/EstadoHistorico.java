package ar.gov.anses.Sentencias.Domain;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name="estado_historico")
public class EstadoHistorico implements java.io.Serializable {


    private static final long serialVersionUID = -524421850320434714L;

    @Id
    @GeneratedValue(strategy= IDENTITY)
    private Long id;

    @Basic(optional=false)
    @Column(name="sentencia_id", precision=11)
    private Long sentenciaId;

    @Column(name="F_Estado")
    private Date FEstado;

    @Column(name="usuario_id", length=20)
    private String usuarioId;

    @Basic(optional=false)
    @Column(name="estado_cod")
    private Integer estadoCod;

    public Integer getEstadoCod() {
        return estadoCod;
    }

    public void setEstadoCod(Integer estadoCod) {
        this.estadoCod = estadoCod;
    }

    /** default constructor */
    public EstadoHistorico() {
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


}
