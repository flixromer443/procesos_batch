package ar.gov.anses.Sentencias.DTO;

import ar.gov.anses.Sentencias.Constantes;

import javax.xml.datatype.XMLGregorianCalendar;

public class EDocumentoOriginalDTO {

    protected String id;
    protected String codigoSistema;
    protected int tipoEDocumentoId;
    protected int estadoEDocumentoId;
    protected String entidad;
    protected Short preCuil;
    protected String numeroDocumento;
    protected Short digitoVerificador;
    protected Integer tipoTramite;
    protected Integer secuencia;
    protected String codigoExterno;
    protected String metadata;
    protected String titulo;
    protected String descripcion;
    protected String nombre;
    protected String ruta;
    protected XMLGregorianCalendar fechaIndexacion;

    /*********************************************************/

    protected int estadoProceso = 0;
    protected String estadoProcesoStr = "NO_PROCESADO";
    protected String fechaIndexacionStr;
    protected String tmpExpedienteAdministrativo;

    public int getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(int estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public String getEstadoProcesoStr() {
        return estadoProcesoStr;
    }

    public void setEstadoProcesoStr(String estadoProcesoStr) {
        this.estadoProcesoStr = estadoProcesoStr;
    }

    public String getFechaIndexacionStr() {
        return fechaIndexacionStr;
    }

    public void setFechaIndexacionStr(String fechaIndexacionStr) {
        this.fechaIndexacionStr = fechaIndexacionStr;
    }

    public String getTmpExpedienteAdministrativo() {
        return tmpExpedienteAdministrativo;
    }

    public void setTmpExpedienteAdministrativo(String tmpExpedienteAdministrativo) {
        this.tmpExpedienteAdministrativo = tmpExpedienteAdministrativo;
    }

    /*********************************************************/
    public String getId() {
        return id;
    }
    public void setId(String value) {
        this.id = value;
    }

    public String getCodigoSistema() {
        return codigoSistema;
    }
    public void setCodigoSistema(String value) {
        this.codigoSistema = value;
    }

    public int getTipoEDocumentoId() {
        return tipoEDocumentoId;
    }
    public void setTipoEDocumentoId(int value) {
        this.tipoEDocumentoId = value;
    }

    public int getEstadoEDocumentoId() {
        return estadoEDocumentoId;
    }
    public void setEstadoEDocumentoId(int value) {
        this.estadoEDocumentoId = value;
    }

    public String getEntidad() {
        return entidad;
    }
    public void setEntidad(String value) {
        this.entidad = value;
    }

    public Short getPreCuil() {
        return preCuil;
    }
    public void setPreCuil(Short value) {
        this.preCuil = value;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    public Short getDigitoVerificador() {
        return digitoVerificador;
    }
    public void setDigitoVerificador(Short value) {
        this.digitoVerificador = value;
    }

    public Integer getTipoTramite() {
        return tipoTramite;
    }
    public void setTipoTramite(Integer value) {
        this.tipoTramite = value;
    }

    public Integer getSecuencia() {
        return secuencia;
    }
    public void setSecuencia(Integer value) {
        this.secuencia = value;
    }

    public String getCodigoExterno() {
        return codigoExterno;
    }
    public void setCodigoExterno(String value) {
        this.codigoExterno = value;
    }

    public String getMetadata() {
        return metadata;
    }
    public void setMetadata(String value) {
        this.metadata = value;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String value) {
        this.titulo = value;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String value) {
        this.nombre = value;
    }

    public String getRuta() {
        return ruta;
    }
    public void setRuta(String value) {
        this.ruta = value;
    }

    public XMLGregorianCalendar getFechaIndexacion() {
        return fechaIndexacion;
    }
    public void setFechaIndexacion(XMLGregorianCalendar value) {
        this.fechaIndexacion = value;
    }

}
