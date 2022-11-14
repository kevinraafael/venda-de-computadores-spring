package apsoo.computadores.domain.dao;

import apsoo.computadores.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa,UUID > {

}