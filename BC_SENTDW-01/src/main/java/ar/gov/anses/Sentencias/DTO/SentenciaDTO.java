package ar.gov.anses.Sentencias.DTO;


import ar.gov.anses.Sentencias.Domain.Sentencias;


public class SentenciaDTO {

    private Long id;
    private Long beneficioTitular;
    private Long cuilTitular;
    private long beneficioCausante;
    private Long cuitCausante;
    private String expedienteAdministrativo;

    public SentenciaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBeneficioTitular() {
        return beneficioTitular;
    }

    public void setBeneficioTitular(Long beneficioTitular) {
        this.beneficioTitular = beneficioTitular;
    }

    public Long getCuilTitular() {
        return cuilTitular;
    }

    public void setCuilTitular(Long cuilTitular) {
        this.cuilTitular = cuilTitular;
    }

    public long getBeneficioCausante() {
        return beneficioCausante;
    }

    public void setBeneficioCausante(long beneficioCausante) {
        this.beneficioCausante = beneficioCausante;
    }

    public Long getCuitCausante() {
        return cuitCausante;
    }

    public void setCuitCausante(Long cuitCausante) {
        this.cuitCausante = cuitCausante;
    }

    public String getExpedienteAdministrativo() {
        return expedienteAdministrativo;
    }

    public void setExpedienteAdministrativo(String expedienteAdministrativo) {
        this.expedienteAdministrativo = expedienteAdministrativo;
    }

    public SentenciaDTO mapToSentenciaDTO(Sentencias sentencia){
        SentenciaDTO sentenciaDTO  = new SentenciaDTO();
        sentenciaDTO.setId(sentencia.getId());
        sentenciaDTO.setBeneficioTitular(sentencia.getBeneficioTitular());
        sentenciaDTO.setCuilTitular(sentencia.getCuilTitular());
        if(sentencia.getBeneficioCausante()!= null && sentencia.getBeneficioCausante()!=null){
            sentenciaDTO.setBeneficioCausante(sentencia.getBeneficioCausante());
            sentenciaDTO.setCuitCausante(sentencia.getCuilCausante());
        }
        sentenciaDTO.setExpedienteAdministrativo(sentencia.getExpedienteAdministrativo());
        return sentenciaDTO;
    }
}
