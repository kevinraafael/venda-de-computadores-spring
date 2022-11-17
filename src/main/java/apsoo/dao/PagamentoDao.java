package apsoo.dao;

import apsoo.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PagamentoDao extends  JpaRepository<Pagamento, UUID> {
}
