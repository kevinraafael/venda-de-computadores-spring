package apsoo.computadores.domain.dao;

import apsoo.computadores.domain.entity.Devolucao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DevolucaoDao extends JpaRepository<Devolucao, UUID> {
}
