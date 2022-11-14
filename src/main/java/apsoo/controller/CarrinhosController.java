package apsoo.controller;



import apsoo.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.rgielen.fxweaver.core.FxmlView;
@Component
@FxmlView("compras.fxml")
public class CarrinhosController {


    @FXML
    private Button finalizaVenda;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField cpfCliente;

    @FXML
    private Label nomeEncontrado ;
    @FXML
    private Label nomeCliente = new Label();


    @FXML
    private GridPane listaComputador;

    @FXML
    private Label totalCarrinho;

    @FXML
    private Label totalQntCarrinho;

    private final int numColunasLista = 3;
//    public String buscaPessoa(Pessoa p){
//        if(service.buscaPorId(p.getId())!=null){
//            return  p.getNome();
//        }
//         return  null;
//    }
@FXML
protected void btnFinalizaVenda(ActionEvent e){
    //MainApplication.trocaTela("compras");
}
}
