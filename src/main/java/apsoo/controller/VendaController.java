package apsoo.controller;

import apsoo.dao.VendaDao;
import apsoo.entity.ItemVenda;
import apsoo.entity.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaController {
   public static Venda venda = new Venda();
   public static ItemVenda itemVenda = new ItemVenda();

}