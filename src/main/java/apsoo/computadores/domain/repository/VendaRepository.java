package apsoo.computadores.domain.repository;

import apsoo.computadores.domain.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {


}
