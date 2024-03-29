package ar.gov.anses.Sentencias.Model;

import ar.gov.anses.Sentencias.DAO.SentenciasDaoImpl;
import ar.gov.anses.Sentencias.DTO.SentenciaDTO;
import ar.gov.anses.Sentencias.Domain.Sentencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenciasModelImpl implements SentenciasModel{

    @Autowired
    private SentenciasDaoImpl sentenciasDao;

    @Override
    public SentenciaDTO findSentenciasById(Long sentenciaId){
        Sentencias sentencia = sentenciasDao.getById(sentenciaId);
        return new SentenciaDTO().mapToSentenciaDTO(sentencia);
    }

}
