package apsoo.controller;


import apsoo.service.PessoaService;
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
