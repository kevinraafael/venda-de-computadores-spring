package apsoo.controller;

import apsoo.dao.PagamentoDao;
import apsoo.dao.PessoaDao;
import apsoo.entity.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoController {
    public static Pagamento pagamento = new Pagamento();
    @Autowired
    public static PagamentoDao pagamentoDao;
}
