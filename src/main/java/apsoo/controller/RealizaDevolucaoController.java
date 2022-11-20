package apsoo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

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
}
