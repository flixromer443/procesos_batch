package ar.gov.anses.Sentencias.Ejecucion;

import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;

import java.util.List;

public interface ModoEjecucion {
    public List<EDocumentoOriginalDTO> ejecutar(List<? extends EDocumentoOriginalDTO> edocumentos, String modoEjecucion);
}
