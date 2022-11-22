package apsoo.controller;

import apsoo.dao.*;
import apsoo.entity.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("realizarDevolucao.fxml")
public class RealizaDevolucaoController implements Initializable {

    @FXML
    private Label nomeClienteXml = new Label();

    @FXML
    private TextField cpfClienteXml;

    @FXML
    private TextField motivoDevolucaoXml;

    @FXML
    private Button buttonDevolucao;

    @FXML
    private ListView<ItemVenda> listViewItemVenda;

    @FXML
    private ListView<Venda> listViewVenda;
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

    @Autowired
    public DevolucaoDao devolucaoDao;

    public  Cliente cliente = new Cliente();
    public  Funcionario funcionario = new Funcionario();
    public Venda venda = new Venda();
    public ItemVenda itemVendaSelecionado = new ItemVenda();
    public List<Venda> vendaList = new ArrayList<>();
    public List<ItemVenda> itemVendaList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      selecionaItensVenda();
    }


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
                    "É" + " necessário cliente estar cadastrado para iniciar a venda ", true);
        }


        // carregaListaComputadores();

    }


    public void buscaVendaDoCliente(ActionEvent e) {
        try {
            //Pega uma lista de venda de acordo com o cliente id
            vendaList = vendaDao.findByCliente_Id(cliente.getId());
            adicionaListViewVenda();
            // adicionaListViewsItemVenda();
        } catch (Exception error) {
            informationDialog(e, "Cliente não possui nenhuma venda realizada", "É necessário " +
                    "ter ao menos uma venda associada para realizar devolução", "Por favor compre algo", true);
        }

    }

    public void adicionaListViewVenda() {
        if (listViewVenda.getItems().isEmpty()) {
            for (int i = 0; i < vendaList.size(); i++) {
                this.listViewVenda.getItems().addAll(vendaList.get(i));
            }
        }
        listViewVenda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Venda>() {
            @Override
            public void changed(ObservableValue<? extends Venda> observable, Venda oldValue, Venda newValue) {
                int indiceSelecionado = listViewVenda.getSelectionModel().getSelectedIndex();
                //Pega o indice da da venda selecionada e procura essa venda por meio do findByVendaID
                //No caso o venda.get(indice) tem que ser a venda selecionada
                itemVendaList = itemVendaDao.findByVenda_Id(vendaList.get(indiceSelecionado).getId());
                adicionaListViewsItemVenda();
            }
        });
    }

    public void adicionaListViewsItemVenda() {
        if (listViewItemVenda.getItems().isEmpty()) {
            this.listViewItemVenda.getItems().addAll(itemVendaList);
        }
    }

    @FXML
    public void selecionaItensVenda() {
        listViewItemVenda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemVenda>() {
            @Override
            public void changed(ObservableValue<? extends ItemVenda> observable, ItemVenda oldValue, ItemVenda newValue) {
                int indiceSelecionado = listViewItemVenda.getSelectionModel().getSelectedIndex();
                itemVendaSelecionado = listViewItemVenda.getSelectionModel().getSelectedItem();
            }
        });

    }

    @FXML
    public void realizaDevolucao(ActionEvent event) {

        try {

            String motivo = motivoDevolucaoXml.getText().toString();
            Devolucao devolucao = new Devolucao();
            devolucao.setItemVenda(itemVendaSelecionado);
            devolucao.setFuncionario(funcionario);
            devolucao.setMotivo(motivo);
            devolucao.setDtDevolucao(new java.util.Date());

            devolucaoDao.save(devolucao);
        } catch (Exception error) {
            informationDialog(event, "Não foi possível realizar a devolução", "Por favor seja paciente",
                    "Tente mais tarde", true);
        } finally {
            informationDialog(event, "Seu comprovante será emitido ", "Devolução registrada com sucesso ",
                    "Agradeço a paciência", false);
        }
    }

    public void informationDialog(ActionEvent event, String title, String headerText, String bottomText, boolean isError) {
        if (isError) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(bottomText);
        alert.showAndWait();
    }



}
