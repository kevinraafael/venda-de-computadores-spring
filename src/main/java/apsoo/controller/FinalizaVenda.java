package apsoo.controller;


import apsoo.AplicacaoJavaFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("finalizaVenda.fxml")
public class FinalizaVenda {
    @FXML
    Pane paneFinalizaVenda;
    public FinalizaVenda() {
    }


    @FXML
    protected void informationDialogVenda(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso!");
        alert.setHeaderText("Venda concluída com SUCESSO!");
        alert.setContentText("Pagamento á vista em dinheiro");
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
        carregarScene(paneFinalizaVenda, CarrinhosController.class);
    }
}
