package ar.gov.anses.Sentencias.DAO;

import ar.gov.anses.Sentencias.Domain.Sentencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenciasDaoImpl extends JpaRepository<Sentencias, Long> {

}
