package apsoo.controller;

import apsoo.dao.*;
import apsoo.entity.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@FxmlView("realizarDevolucao.fxml")
public class RealizaDevolucaoController {

    @FXML
    private Label nomeClienteXml = new Label();

    @FXML
    private TextField cpfClienteXml;

    @FXML
    private TextField motivoDevolucaoXml;

    @FXML
    private Button buttonDevolcaoXml;

    @FXML
    private ListView<String> listViewItemVenda;

    @FXML
    private ListView<String> listViewVenda;
    @Autowired
    public ClienteDao clientDao;
    @Autowired
    public PessoaDao pessoaDao;
    @Autowired
    public FuncionarioDao funcionarioDao;

    @Autowired
    public VendaDao vendaDao;
    @Autowired
    public ItemVendaDao itemVendaDao;

    public static Cliente cliente = new Cliente();
    public static Funcionario funcionario = new Funcionario();
    public Venda venda = new Venda();
    public List<Venda> vendaList = new ArrayList<>();
    public List<ItemVenda> itemVendaList = new ArrayList<>();

    @FXML
    public void buscaCliente(ActionEvent e) {

        try {
            String cpf = cpfClienteXml.getText().toString();
            //  retornar uma  lista de pessoa
            // e como cpf é unico logo estará  sempre na primeira na primeira posição da lista
            List<Pessoa> pessoa = pessoaDao.findByCpf(cpf);
            List<Pessoa> pessoaFuncionario = pessoaDao.findByCpf("14317576082");
            List<Cliente> clientes = clientDao.findByPessoa_Id(pessoa.get(0).getId());
            List<Funcionario> funcionarios = funcionarioDao.findByPessoa_Id(pessoaFuncionario.get(0).getId());
            System.out.println(funcionarios.get(0).getData_contratacao());
            //Verifico se a pessoa já é um cliente
            cliente = clientes.get(0);
            funcionario = funcionarios.get(0);

            System.out.println(cliente.getPessoa().getNome());


            Pessoa pessoaEncontrada = clientes.get(0).getPessoa();
            String nomeEncontrado = pessoaEncontrada.getNome();
            nomeClienteXml.setText(nomeEncontrado);
            buscaVendaDoCliente(e);

        } catch (Exception error) {
            informationDialog(e, "Cliente não encontrado", "Por favor faça o cadastro do cliente",
                    "É" + " necessário cliente estar cadastrado para iniciar a venda ");
        }


        // carregaListaComputadores();

    }


    public void buscaVendaDoCliente(ActionEvent e) {
        try {
            //Pega uma lista de venda de acordo com o cliente id
            vendaList = vendaDao.findByCliente_Id(cliente.getId());
            //Pega o indice da da venda selecionada e procura essa vemda por meio do findByVendaID
            //No caso o vendaget(0) tem que ser a venda selecionada
            itemVendaList = itemVendaDao.findByVenda_Id(vendaList.get(1).getId());
            adicionaListViewVenda();
           // adicionaListViewsItemVenda();
        } catch (Exception error) {
            informationDialog(e, "Cliente não possui nenhuma venda realizada", "É necessário " +
                    "ter ao menos uma venda associada para realizar devolução", "Por favor compre algo");
        }

    }

    public void adicionaListViewVenda() {
        if (listViewVenda.getItems().isEmpty()) {
            for (int i = 0; i < vendaList.size(); i++) {
                this.listViewVenda.getItems().addAll(vendaList.get(i).toString());
            }
        }
        listViewVenda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
             int indiceSelecionado =   listViewVenda.getSelectionModel().getSelectedIndex();
                adicionaListViewsItemVenda();
            }
        });

    }

    public void adicionaListViewsItemVenda() {
        if (listViewItemVenda.getItems().isEmpty()) {
            this.listViewItemVenda.getItems().addAll(itemVendaList.get(0).getComputador().toString());
        }

    }

    public void informationDialog(ActionEvent event, String title, String headerText, String bottomText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(bottomText);
        alert.showAndWait();
    }
}
