package apsoo.dao;

import apsoo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ClienteDao extends JpaRepository<Cliente, UUID> {
  List<Cliente> findByPessoa_Id(UUID id);
}
