package apsoo.dao;

import apsoo.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa,UUID > {
    List<Pessoa> findByCpf(String cpf);

}