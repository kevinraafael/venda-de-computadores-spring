package apsoo.computadores.domain.repository;

import apsoo.computadores.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface  PagamentoRepository extends  JpaRepository<Pagamento, UUID> {
}
