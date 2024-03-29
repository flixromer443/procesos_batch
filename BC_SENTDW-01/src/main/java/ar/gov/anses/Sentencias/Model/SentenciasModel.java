package ar.gov.anses.Sentencias.Model;

import ar.gov.anses.Sentencias.DTO.SentenciaDTO;

public interface SentenciasModel {

    public SentenciaDTO findSentenciasById(Long sentenciaId);

}
