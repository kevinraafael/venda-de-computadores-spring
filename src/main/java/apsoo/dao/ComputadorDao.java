package apsoo.dao;

import apsoo.entity.Computador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputadorDao extends JpaRepository<Computador, UUID> {
}
