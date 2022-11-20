package apsoo.controller;


import apsoo.AplicacaoJavaFx;
import apsoo.entity.ItemVenda;
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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    private ListView<String> listViewItemVenda;
    @FXML
    private Label totalItensCarrinho;



    private ObservableList<ItemVenda> obsListItensVenda;

    public FinalizaVendaController() {
    }


    @FXML
    protected void informationDialogVenda(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso!");
        alert.setHeaderText("Venda concluída com SUCESSO!");
        alert.setContentText("Aproveite seu novo produto");
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
      informationDialogVenda(e);
    }

    @FXML
    public void atualizaLayout() {

        String valorTotalString = ItensCarrinhoController.valorTotal;
        valorTotal.setText( Double.toString(descontoPix(valorTotalString)));
        if(this.listViewItemVenda.getItems().isEmpty()){
            carregaLista();
        }
        int totalItensInt = VendaController.itemVendaList.size();
        String totalItens = String.valueOf( totalItensInt);
        totalItensCarrinho.setText(totalItens);

    }

    public void carregaLista() {
        for (int i = 0; i < VendaController.itemVendaList.size(); i++) {

            this.listViewItemVenda.getItems().addAll(VendaController.itemVendaList.get(i).getComputador().toString());
        }

    }

    public double descontoPix(String valorTotal) {
        double valorTotalDouble = Double.parseDouble(ItensCarrinhoController.valorTotal);
        if (radioButtonPix.isSelected()) {
            double desconto =valorTotalDouble * 0.1;
            valorTotalDouble =valorTotalDouble -desconto;
        }
        return valorTotalDouble;

    }


}
