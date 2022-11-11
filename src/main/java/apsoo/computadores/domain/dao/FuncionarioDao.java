package apsoo.computadores.domain.dao;

import apsoo.computadores.domain.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioDao extends JpaRepository<Funcionario, UUID> {
}
