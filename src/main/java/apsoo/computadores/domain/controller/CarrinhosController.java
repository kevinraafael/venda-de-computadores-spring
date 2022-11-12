package apsoo.computadores.domain.controller;


import apsoo.computadores.ComputadoresApplication;
import apsoo.computadores.domain.entity.Pessoa;
import apsoo.computadores.domain.service.PessoaService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class CarrinhosController {
    private final PessoaService service;
    @Value("classpath:/views/CarrinhoDeCompras.fxml")
    private Resource chartResource;
    private void attachEvent() {
        System.out.println("AttackEvent");
//        loginId.getScene().setOnKeyPressed(event -> {
//
//            if(event.getCode() == KeyCode.ENTER) {
//
//                if(closeBtn.isFocused()) {
//                    close();
//                }
//
//                if(loginBtn.isFocused()) {
//                    login();
//                }
//            }
//        });
    }
    public  URL fxmlLocation = getClass().getResource("CarrinhoDeCompras.fxml");
    public URL fxmlLocationStatic = fxmlLocation;
    public static void loadView(Stage stage) {

        try {


           FXMLLoader loader = new FXMLLoader(CarrinhosController.class.getResource("CarrinhoDeCompras.fxml"));

            loader.setControllerFactory(ComputadoresApplication.getApplicationContext()::getBean);

            Parent view = loader.load();
            stage.setScene(new Scene(view));

            //stage.initStyle(StageStyle.UNDECORATED);

            CarrinhosController controller = loader.getController();
            controller.attachEvent();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
