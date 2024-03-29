package ar.gov.anses.Sentencias.DTO;

public class UsuarioDTO {

    private String usuarioRed;
    private String nombre;
    private String oficina;
    private String situacion;

    public UsuarioDTO() {
    }

    public String getUsuarioRed() {
        return usuarioRed;
    }

    public void setUsuarioRed(String usuarioRed) {
        this.usuarioRed = usuarioRed;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
}
