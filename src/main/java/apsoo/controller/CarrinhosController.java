package apsoo.controller;


import apsoo.AplicacaoJavaFx;
import apsoo.AplicacaoSpring;
import apsoo.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
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
    private VBox viewFinalizaVenda;

    private final int numColunasLista = 3;

    public CarrinhosController() {
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
        carregarScene(viewFinalizaVenda, FinalizaVenda.class);
    }

}
