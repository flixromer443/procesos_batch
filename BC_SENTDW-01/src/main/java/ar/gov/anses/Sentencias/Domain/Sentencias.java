package ar.gov.anses.Sentencias.Domain;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Sentencias implements java.io.Serializable {
    private static final long serialVersionUID = -5879997820339078782L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="Beneficio_tit", nullable=false)
    private long beneficioTitular;

    @Column(name="CUIL_tit", nullable=false)
    private long cuilTitular;

    @Column(name="CUIL_caus")
    private long cuilCausante;

    @Column(name="Beneficio_caus")
    private Long beneficioCausante;

    @Column(name="F_emision")
    private Date fechaEmision;

    @Column(name="F_notif")
    private Date fechaNotificacion;

    @Column(name="F_recep")
    private Date fechaRecepcion;

    @Column(name="Estado_cod")
    private Integer estadoCodigo;

    @Column(name="Copart")
    private Integer porcentajeCoparticipacion;

    @Column(name="Causa")
    private String causa;

    @Column(name="juzgado")
    private String juzgado;

    @Column(name="Expediente_judicial")
    private String expedienteJudicial;

    @Column(name="F_fin_carga1")
    private Date fechaFinCarga1;

    @Transient
    private Date fechaFinCarga2;

    @Column(name="Resolucion")
    private Long resolucion;

    @Column(name="carga_id_final")
    private Long cargaFinalId;

    @Column(name="Expediente_administrativo")
    private String expedienteAdministrativo;

    @Column(name="numero_liquidacion")
    private Integer numeroLiquidacion;

    @Column(name="tipo_liquidacion")
    private Integer tipoLiquidacion;

    @Column(name="user_liquidacion")
    private String userLiquidacion;

    @Column(name="ley_aplicada")
    private Integer leyAplicada;

    @Column(name="tipo_prestacion")
    private Integer tipoPrestacion;

    @Column(name="tipo_tramite")
    private Integer tipoTramite;

    @Column(name="razon_estado")
    private Integer razonLiquidacionManual;

    public String getUserLiquidacion() {
        return userLiquidacion;
    }

    public void setUserLiquidacion(String userLiquidacion) {
        this.userLiquidacion = userLiquidacion;
    }

    public String getExpedienteAdministrativo() {
        return expedienteAdministrativo;
    }

    public void setExpedienteAdministrativo(String expedienteAdministrativo) {
        this.expedienteAdministrativo = expedienteAdministrativo;
    }

    public Sentencias() {
    }

    public Sentencias(Long id, long beneficioTitular, long cuilTitular, long cuilCausante) {
        this.id = id;
        this.beneficioTitular = beneficioTitular;
        this.cuilTitular = cuilTitular;
        this.cuilCausante = cuilCausante;
    }

    public Sentencias(Long id, long beneficioTitular, long cuilTitular, long cuilCausante,
                      Long beneficioCausante, Date fechaEmision, Date fechaNotificacion, Date fechaRecepcion,
                      Integer estadoCodigo, Integer porcentajeCoparticipacion, String causa, String juzgado,
                      String expedienteJudicial, Date fechaFinCarga1) {
        this.id = id;
        this.beneficioTitular = beneficioTitular;
        this.cuilTitular = cuilTitular;
        this.cuilCausante = cuilCausante;
        this.beneficioCausante = beneficioCausante;
        this.fechaEmision = fechaEmision;
        this.fechaNotificacion = fechaNotificacion;
        this.fechaRecepcion = fechaRecepcion;
        this.estadoCodigo = estadoCodigo;
        this.porcentajeCoparticipacion = porcentajeCoparticipacion;
        this.causa = causa;
        this.juzgado = juzgado;
        this.expedienteJudicial = expedienteJudicial;
        this.fechaFinCarga1 = fechaFinCarga1;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBeneficioTitular() {
        return this.beneficioTitular;
    }

    public void setBeneficioTitular(long beneficioTitular) {
        this.beneficioTitular = beneficioTitular;
    }

    public long getCuilTitular() {
        return this.cuilTitular;
    }

    public void setCuilTitular(long cuilTitular) {
        this.cuilTitular = cuilTitular;
    }

    public long getCuilCausante() {
        return this.cuilCausante;
    }

    public void setCuilCausante(long cuilCausante) {
        this.cuilCausante = cuilCausante;
    }

    public Long getBeneficioCausante() {
        return this.beneficioCausante;
    }

    public void setBeneficioCausante(Long beneficioCausante) {
        this.beneficioCausante = beneficioCausante;
    }

    public Date getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaNotificacion() {
        return this.fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Date getFechaRecepcion() {
        return this.fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Integer getEstadoCodigo() {
        return this.estadoCodigo;
    }

    public void setEstadoCodigo(Integer estadoCodigo) {
        this.estadoCodigo = estadoCodigo;
    }

    public Integer getPorcentajeCoparticipacion() {
        return this.porcentajeCoparticipacion;
    }

    public void setPorcentajeCoparticipacion(Integer porcentajeCoparticipacion) {
        this.porcentajeCoparticipacion = porcentajeCoparticipacion;
    }

    public String getCausa() {
        return this.causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getJuzgado() {
        return this.juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    public String getExpedienteJudicial() {
        return this.expedienteJudicial;
    }

    public void setExpedienteJudicial(String expedienteJudicial) {
        this.expedienteJudicial = expedienteJudicial;
    }

    public Date getFechaFinCarga1() {
        return this.fechaFinCarga1;
    }

    public void setFechaFinCarga1(Date fechaFinCarga1) {
        this.fechaFinCarga1 = fechaFinCarga1;
    }

    public Date getFFinCarga2() {
        return fechaFinCarga2;
    }

    public void setFFinCarga2(Date finCarga2) {
        fechaFinCarga2 = finCarga2;
    }

    public Long getResolucion() {
        return resolucion;
    }

    public void setResolucion(Long resolucion) {
        this.resolucion = resolucion;
    }

    public Long getCargaFinalId() {
        return cargaFinalId;
    }

    public void setCargaFinalId(Long cargaFinalId) {
        this.cargaFinalId = cargaFinalId;
    }

    public Integer getNumeroLiquidacion() {
        return numeroLiquidacion;
    }

    public void setNumeroLiquidacion(Integer numeroLiquidacion) {
        this.numeroLiquidacion = numeroLiquidacion;
    }

    public Integer getTipoLiquidacion() {
        return tipoLiquidacion;
    }

    public void setTipoLiquidacion(Integer tipoLiquidacion) {
        this.tipoLiquidacion = tipoLiquidacion;
    }

    public void setLeyAplicada(Integer leyAplicada) {
        this.leyAplicada = leyAplicada;
    }

    public Integer getLeyAplicada() {
        return leyAplicada;
    }

    public void setTipoPrestacion(Integer tipoPrestacion) {
        this.tipoPrestacion = tipoPrestacion;
    }

    public Integer getTipoPrestacion() {
        return tipoPrestacion;
    }

    public void setTipoTramite(Integer tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Integer getTipoTramite() {
        return tipoTramite;
    }

    public void setRazonLiquidacionManual(Integer razonLiquidacionManual) {
        this.razonLiquidacionManual = razonLiquidacionManual;
    }

    public Integer getRazonLiquidacionManual() {
        return razonLiquidacionManual;
    }
}
