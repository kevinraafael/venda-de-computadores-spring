package apsoo.dao;

import apsoo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteDao extends JpaRepository<Cliente, UUID> {
}
