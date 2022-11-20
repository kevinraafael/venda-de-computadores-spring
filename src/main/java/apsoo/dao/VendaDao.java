package apsoo.dao;

import apsoo.entity.Cliente;
import apsoo.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface VendaDao extends JpaRepository<Venda, UUID> {

    @Transactional
    List<Venda> findByCliente_Id(UUID id);

}
