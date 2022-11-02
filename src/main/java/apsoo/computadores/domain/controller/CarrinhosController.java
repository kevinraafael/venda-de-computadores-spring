package apsoo.computadores.domain.controller;


import apsoo.computadores.domain.entity.Pessoa;
import apsoo.computadores.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarrinhosController {
    private final PessoaService service;

//    public String buscaPessoa(Pessoa p){
//        if(service.buscaPorId(p.getId())!=null){
//            return  p.getNome();
//        }
//         return  null;
//    }
}
