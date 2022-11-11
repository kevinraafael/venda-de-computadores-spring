package apsoo.computadores.domain.service;

import apsoo.computadores.domain.entity.Pessoa;
import apsoo.computadores.domain.dao.PessoaDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaDao repository;

    public Pessoa salvar(Pessoa pessoa ){
    return  repository.save(pessoa);
    }
    public List<Pessoa> listarTodos(){
        return  repository.findAll();
    }
    public Optional <Pessoa>buscaPorId(UUID id){
        return  repository.findById(id);
    }
}
