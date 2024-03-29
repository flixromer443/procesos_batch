using System;
using System.Collections.Generic;
using System.Text;

namespace PruebaBatch01.Sentencias.DTO
{
    class SentenciaDTO
    {
        private long id;
        private long beneficioTitular;
        private long cuilTitular;
        private long beneficioCausante;
        private long cuitCausante;
        private string expedienteAdministrativo;

        public SentenciaDTO()
        {
        }

        public long getId()
        {
            return id;
        }

        public void setId(long id)
        {
            this.id = id;
        }

        public long getBeneficioTitular()
        {
            return beneficioTitular;
        }

        public void setBeneficioTitular(long beneficioTitular)
        {
            this.beneficioTitular = beneficioTitular;
        }

        public long getCuilTitular()
        {
            return cuilTitular;
        }

        public void setCuilTitular(long cuilTitular)
        {
            this.cuilTitular = cuilTitular;
        }

        public long getBeneficioCausante()
        {
            return beneficioCausante;
        }

        public void setBeneficioCausante(long beneficioCausante)
        {
            this.beneficioCausante = beneficioCausante;
        }

        public long getCuitCausante()
        {
            return cuitCausante;
        }

        public void setCuitCausante(long cuitCausante)
        {
            this.cuitCausante = cuitCausante;
        }

        public string getExpedienteAdministrativo()
        {
            return expedienteAdministrativo;
        }

        public void setExpedienteAdministrativo(string expedienteAdministrativo)
        {
            this.expedienteAdministrativo = expedienteAdministrativo;
        }

        /*public SentenciaDTO mapToSentenciaDTO(Sentencias sentencia)
        {

          
            SentenciaDTO sentenciaDTO = new SentenciaDTO();
            sentenciaDTO.setId(sentencia.getId());
            sentenciaDTO.setBeneficioTitular(sentencia.getBeneficioTitular());
            sentenciaDTO.setCuilTitular(sentencia.getCuilTitular());
            if (sentencia.getBeneficioCausante() != null && sentencia.getBeneficioCausante() != null)
            {
                sentenciaDTO.setBeneficioCausante(sentencia.getBeneficioCausante());
                sentenciaDTO.setCuitCausante(sentencia.getCuilCausante());
            }
            sentenciaDTO.setExpedienteAdministrativo(sentencia.getExpedienteAdministrativo());
            return sentenciaDTO;
        }*/

    }
}
