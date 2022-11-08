package apsoo.computadores.domain.service;

import apsoo.computadores.domain.entity.Pessoa;
import apsoo.computadores.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {

    private final  PessoaRepository repository;

    public Pessoa salvar(Pessoa pessoa ){
    return  repository.save(pessoa);
    }
    public List<Pessoa> listarTodos(){
        return  repository.findAll();
    }
    public Optional <Pessoa>buscaPorId(UUID id){
        return  repository.findById(id);
    }

    /*
    Função que realizará a busca do pessoa cadastrada e retornará seu nome
    para poder exibir logo no início da aplicação após informado o cpf
    */

    public Optional <String> buscaPessoa(UUID id){
      return Optional.ofNullable(repository.findById(id).get().getNome());
    }
}
