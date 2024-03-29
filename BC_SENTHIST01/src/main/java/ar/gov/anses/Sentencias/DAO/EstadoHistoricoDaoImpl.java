package ar.gov.anses.Sentencias.DAO;

import ar.gov.anses.Sentencias.Domain.EstadoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoHistoricoDaoImpl extends JpaRepository<EstadoHistorico, Long>{
    @Query(value = "SELECT * FROM estado_historico WHERE estado_cod = 12", nativeQuery = true)
    List<EstadoHistorico> findEstadosHistoricos12();
}
