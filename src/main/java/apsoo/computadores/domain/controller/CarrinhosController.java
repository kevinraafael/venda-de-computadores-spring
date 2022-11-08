package apsoo.computadores.domain.controller;


import apsoo.computadores.CarrinhoDeCompras;
import apsoo.computadores.domain.entity.Pessoa;
import apsoo.computadores.domain.repository.PessoaRepository;
import apsoo.computadores.domain.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import lombok.RequiredArgsConstructor;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

//@RequiredArgsConstructor
public class CarrinhosController implements Initializable {
    //private final PessoaService service;
    @FXML
    public Button finalizaVenda;

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

    private apsoo.computadores.domain.repository.PessoaRepository PessoaRepository;
    /**
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */

   private  final  PessoaService pessoaService = new PessoaService(PessoaRepository);
    @FXML
    protected void buscaCliente(ActionEvent event) throws SQLException, ClassNotFoundException {

//        Pessoa p = new Pessoa();
//        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres",
//                "postgres",
//                "senha@123");
//        conexao.realizaConexao();
//
//        try {
//            Pessoa pessoaEncontrada = p.buscaPessoa(cpfCliente.getText(), conexao.getConnection());
//            Cliente cliente = new Cliente();
//            cliente.verificaSeECliente(cpfCliente.getText(), conexao);
//            nomeCliente.setText(pessoaEncontrada.getNome());
//            conexao.getConnection().close();
//        } catch (Exception e) {
//            informationDialog(event, "Ocorreu um erro", e.toString(),
//                    "Por favor adicione o cliente");
//        }
//        PessoaRepository pessoaRepository ;
//
        String teste = String.valueOf(pessoaService.buscaPessoa(UUID.fromString("686dc24c-926a-4566-a8f1-5d7344114323")));
        System.out.println(teste);
//        if(service){
//            return  p.getNome();
//        }
    }

    protected void informationDialog(ActionEvent event, String title, String headerText, String bottomText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(bottomText);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // try {

//            Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres",
//                    "postgres",
//                    "senha@123");
//            conexao.realizaConexao();
//            List<Computador> computadores = new Computador().getComputadores(conexao.getConnection());
//
//            for (int rowIndex = 0; rowIndex < 2; rowIndex++) {
//                for (int collIndex = 0; collIndex < numColunasLista; collIndex++) {
//                    int pcCollumns = (int) Math.floor((double) computadores.size() / numColunasLista);
//                    int pcIndex = (rowIndex * pcCollumns) + collIndex;
//                    if (pcIndex == computadores.size() - 1) {
//                        String pcTitle = computadores.get(pcIndex).getModelo() + " "
//                                + computadores.get(pcIndex).getProcessador();
//                        String pcValor = computadores.get(pcIndex).getValor().toString();
//
//                        listaComputador.add(
//                                new ComputadorComponent("/assets/PC.jpg", pcTitle, pcValor,
//                                        totalCarrinho, totalQntCarrinho),
//                                collIndex, rowIndex);
//                        return;
//                    } else {
//                        String pcTitle = computadores.get(pcIndex).getModelo() + " "
//                                + computadores.get(pcIndex).getProcessador();
//                        String pcValor = computadores.get(pcIndex).getValor().toString();
//
//                        listaComputador.add(
//                                new ComputadorComponent("/assets/PC.jpg", pcTitle, pcValor,
//                                        totalCarrinho, totalQntCarrinho),
//                                collIndex, rowIndex);
//                    }
//
//                }
//            }
//
//            conexao.getConnection().close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            // throw e;
//        }

    }

    @FXML
    protected void btnFinalizaVenda(ActionEvent e){
       // MainApplication.trocaTela("compras");
    }

    @FXML
    public void buscaPessoa(Pessoa p){
        PessoaRepository pessoaRepository ;

       // String teste = pessoaService.buscaPessoa('686dc24c-926a-4566-a8f1-5d7344114323');
       // System.out.println(teste);
//        if(service){
//            return  p.getNome();
//        }
//         return  null;
    }


//    @FXML
//    protected void btnFinalizaVenda(ActionEvent e){
//        CarrinhoDeCompras.trocaTela("compras");
//    }

}
