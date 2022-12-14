package apsoo.controller;


import apsoo.AplicacaoJavaFx;
import apsoo.dao.*;
import apsoo.entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@FxmlView("itensCarrinho.fxml")
public class ItensCarrinhoController {

    @FXML
    private Button finalizaVenda;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField cpfCliente;

    @FXML
    private Label nomeEncontrado;
    @FXML
    private Label nomeCliente = new Label();
    @FXML
    private GridPane listaComputador;

    @FXML
    private Label totalCarrinho;

    @FXML
    private Label totalQntCarrinho;

    @FXML
     VBox viewAtual;

    @FXML
    private Button buttonDevolucao;


    @Autowired
    public ComputadorDao computadorDao;

    @Autowired
    public ClienteDao clientDao;
    @Autowired
    public PessoaDao pessoaDao;

    @Autowired
    public FuncionarioDao funcionarioDao;

    @Autowired
    public PagamentoDao pagamentoDao;

    @Autowired
    public VendaDao vendaDao;

    @Autowired
    public ItemVendaDao itemVendaDao;

    private Random numeroAleatorio;
    private final int numColunasLista = 3;

    public static Cliente cliente = new Cliente();
    public static Funcionario funcionario = new Funcionario();
    public static String valorTotal;

    public ItensCarrinhoController() {
    }

    public void carregarScene(Node parent, Class controller) {

        // Utiliza o parente para acessar a Stage
        Stage stage = (Stage) parent.getScene().getWindow();

        // Pegar o Bean do JavaFXWeaver
        FxWeaver fxWeaver = AplicacaoJavaFx.contextoSpring.getBean(FxWeaver.class);

        // O FXWeaver carrega o controlador na mem??ria
        Parent root = (Parent) fxWeaver.loadView(controller);

        // Associa o controlador a uma cena
        Scene scene = new Scene(root);

        // Associa a cena ?? tela atual
        stage.setScene(scene);

        stage.show();

    }


    @FXML
    public void btnVaiParaFinalizaVenda(ActionEvent e) {

        //int codigo = numeroAleatorio.nextInt(99);
        try {
            iniciaVenda();
        } catch (Error error
        ) {
            System.out.println(e);
        } finally {
            carregarScene(viewAtual, FinalizaVendaController.class);
        }


    }
    public void btnVaiParaDevolucao(ActionEvent e){
        carregarScene(viewAtual, RealizaDevolucaoController.class);
    }

    @FXML
    public void buscaCliente(ActionEvent e) {

        try {
            String cpf = cpfCliente.getText().toString();
            //  retornar uma  lista de pessoa
            // e como cpf ?? unico logo estar??  sempre na primeira na primeira posi????o da lista
            List<Pessoa> pessoa = pessoaDao.findByCpf(cpf);
            List<Pessoa> pessoaFuncionario = pessoaDao.findByCpf("14317576082");
            List<Cliente> clientes = clientDao.findByPessoa_Id(pessoa.get(0).getId());
            List<Funcionario> funcionarios = funcionarioDao.findByPessoa_Id(pessoaFuncionario.get(0).getId());
            System.out.println(funcionarios.get(0).getData_contratacao());
            //Verifico se a pessoa j?? ?? um cliente
            cliente = clientes.get(0);
            funcionario = funcionarios.get(0);
            System.out.println(cliente.getPessoa().getNome());


            Pessoa pessoaEncontrada = clientes.get(0).getPessoa();
            String nomeEncontrado = pessoaEncontrada.getNome();
            nomeCliente.setText(nomeEncontrado);


        } catch (Exception error) {
            informationDialog(e, "Cliente n??o encontrado", "Por favor fa??a o cadastro do cliente",
                    "??" + " necess??rio cliente estar cadastrado para iniciar a venda ");
        }


        carregaListaComputadores();

    }

    public void carregaListaComputadores() {
        try {


            List<Computador> computadores = computadorDao.findAll();


            for (int rowIndex = 0; rowIndex < 2; rowIndex++) {
                for (int collIndex = 0; collIndex < numColunasLista; collIndex++) {
                    int pcCollumns = (int) Math.floor((double) computadores.size() / numColunasLista);
                    int pcIndex = (rowIndex * pcCollumns) + collIndex;
                    if (pcIndex == computadores.size() - 1) {
                        String pcTitle = computadores.get(pcIndex).getModelo() + " "
                                + computadores.get(pcIndex).getProcessador();
                        String pcValor = computadores.get(pcIndex).getValor().toString();

                        listaComputador.add(
                                new ComputadorComponent("/assets/PC.jpg", pcTitle, pcValor,
                                        totalCarrinho, totalQntCarrinho, computadores.get(pcIndex)),
                                collIndex, rowIndex);
                        return;
                    } else {
                        String pcTitle = computadores.get(pcIndex).getModelo() + " "
                                + computadores.get(pcIndex).getProcessador();
                        String pcValor = computadores.get(pcIndex).getValor().toString();

                        listaComputador.add(
                                new ComputadorComponent("/apsoo/controller/assets/PC.jpg", pcTitle, pcValor,
                                        totalCarrinho, totalQntCarrinho, computadores.get(pcIndex)),
                                collIndex, rowIndex);
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // throw e;
        }

    }

    public void informationDialog(ActionEvent event, String title, String headerText, String bottomText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(bottomText);
        alert.showAndWait();
    }

    public void iniciaVenda() {
        try{
            pagamentoDao.save(PagamentoController.pagamento);
            VendaController.venda.setCliente(ItensCarrinhoController.cliente);
            VendaController.venda.setCodigo(99);
            VendaController.venda.setFuncionario(ItensCarrinhoController.funcionario);
            VendaController.venda.setFormaPagemnto(PagamentoController.pagamento);
            VendaController.venda.setValor(Double.valueOf(PagamentoController.pagamento.getValorTotal()));
            valorTotal = String.valueOf(PagamentoController.pagamento.getValorTotal());
            vendaDao.save(VendaController.venda);
            salvaItensVenda();
        }catch (Exception e){
           System.out.println(e);
        }
    }
    public void salvaItensVenda(){

        for(int i= 0;i<VendaController.itemVendaList.size();i++){
            VendaController.itemVendaList.get(i).setVenda(VendaController.venda);
            itemVendaDao.save( VendaController.itemVendaList.get(i));

        }
    }


}
