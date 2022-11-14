package apsoo.computadores.domain.dao;

import apsoo.computadores.domain.entity.Computador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputadorDao extends JpaRepository<Computador, UUID> {
}
