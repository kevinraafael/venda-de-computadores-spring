package apsoo.controller;


import apsoo.AplicacaoJavaFx;
import apsoo.dao.PagamentoDao;
import apsoo.dao.VendaDao;
import apsoo.entity.ItemVenda;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("finalizaVenda.fxml")
public class FinalizaVendaController {
    @FXML
    Pane paneFinalizaVenda;

    @FXML
    public Label valorTotal;
    @FXML
    public Button atualiza;
    @FXML
    public RadioButton radioButtonPix;
    @FXML
    public RadioButton radioButtonCredito;
    @FXML
    public RadioButton radioButtonDebito;
    @FXML
    public RadioButton radioButtonDinheiro;
    @FXML
    private ListView<String> listViewItemVenda ;
    @FXML
    private Label totalItensCarrinho;

    @Autowired
    public PagamentoDao pagamentoDao;

    @Autowired
    public VendaDao vendaDao;


    private Double desconto = 0.0;

    private ObservableList<ItemVenda> obsListItensVenda;

    public FinalizaVendaController() {
    }


    @FXML
    public void informationDialog(ActionEvent event, String title, String headerText, String bottomText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(bottomText);
        alert.showAndWait();
    }

    public void carregarScene(Node parent, Class controller) {

        // Utiliza o parente para acessar a Stage
        Stage stage = (Stage) parent.getScene().getWindow();

        // Pegar o Bean do JavaFXWeaver
        FxWeaver fxWeaver = AplicacaoJavaFx.contextoSpring.getBean(FxWeaver.class);

        // O FXWeaver carrega o controlador na memória
        Parent root = (Parent) fxWeaver.loadView(controller);

        // Associa o controlador a uma cena
        Scene scene = new Scene(root);

        // Associa a cena à tela atual
        stage.setScene(scene);

        stage.show();

    }

    @FXML
    public void btnFinalizaVenda(ActionEvent e) {
        try {
            verificaFormaDePagamento(ItensCarrinhoController.valorTotal);
            realizaVenda();
        } catch (Exception error) {
            informationDialog(e, "Ocorreu um problema ao finalizar a venda", "iremos corrigir",
                    "Por favor aguarde");
        } finally {
            informationDialog(e, "Venda realizada com sucesso", "Venda Realizada",
                    "Caso tenha problema, procure realizar devolução");
        }

    }

    @FXML
    public void atualizaLayout() {

        String valorTotalString = ItensCarrinhoController.valorTotal;
        valorTotal.setText(Double.toString(verificaFormaDePagamento(valorTotalString)));
        if (this.listViewItemVenda.getItems().isEmpty()) {
            carregaLista();
        }
        int totalItensInt = VendaController.itemVendaList.size();
        String totalItens = String.valueOf(totalItensInt);
        totalItensCarrinho.setText(totalItens);

    }

    public void carregaLista() {
        for (int i = 0; i < VendaController.itemVendaList.size(); i++) {

            this.listViewItemVenda.getItems().addAll(VendaController.itemVendaList.get(i).getComputador().toString());
        }

    }

    public double verificaFormaDePagamento(String valorTotal) {
        double valorTotalDouble = Double.parseDouble(ItensCarrinhoController.valorTotal);
        if (radioButtonPix.isSelected()) {
            this.desconto = valorTotalDouble * 0.1;
            valorTotalDouble = valorTotalDouble - desconto;
            PagamentoController.pagamento.setDesconto(desconto);
            PagamentoController.pagamento.setValorTotal(valorTotalDouble);
            PagamentoController.pagamento.setTipoPagamento("PIX");
        } else if (radioButtonCredito.isSelected()) {
            PagamentoController.pagamento.setDesconto(0.0);
            PagamentoController.pagamento.setValorTotal(valorTotalDouble);
            PagamentoController.pagamento.setTipoPagamento("Credito");
        } else if (radioButtonDebito.isSelected()) {
            PagamentoController.pagamento.setDesconto(0.0);
            PagamentoController.pagamento.setValorTotal(valorTotalDouble);
            PagamentoController.pagamento.setTipoPagamento("Debito");
        } else if (radioButtonDinheiro.isSelected()) {
            PagamentoController.pagamento.setDesconto(0.0);
            PagamentoController.pagamento.setValorTotal(valorTotalDouble);
            PagamentoController.pagamento.setTipoPagamento("Dinheiro");
        }
        return valorTotalDouble;

    }

    public void realizaVenda() {
        try {

            pagamentoDao.save(PagamentoController.pagamento);
            VendaController.venda.setCliente(ItensCarrinhoController.cliente);
            VendaController.venda.setCodigo(99);
            VendaController.venda.setFuncionario(ItensCarrinhoController.funcionario);
            VendaController.venda.setFormaPagemnto(PagamentoController.pagamento);
            VendaController.venda.setValor(Double.valueOf(PagamentoController.pagamento.getValorTotal()));
            VendaController.venda.setItemVendas(VendaController.itemVendaList);
            vendaDao.save(VendaController.venda);


        } catch (Exception e) {
            System.out.println(e);
        }
    }




}
