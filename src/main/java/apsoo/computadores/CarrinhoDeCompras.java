package apsoo.computadores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CarrinhoDeCompras implements ApplicationListener<ChartApplication.StageReadyEvent> {

    @Value("classpath:/views/CarrinhoDeCompras.fxml")
    private Resource chartResource;
//
//    @Value("classpath:/views/Compras.fxml")
//    public static Resource chartResource2;

    @Override
    public void onApplicationEvent(ChartApplication.StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());
            Parent parent = fxmlLoader.load();

            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 1280, 720));
            stage.show();


//            Parent fxmlCompras = FXMLLoader.load(getClass().getClassLoader().getResource("Compras.fxml"));
//            compraScene = new Scene(fxmlCompras);
//
//            Stage compraScene = event.getStage();
//            stage.setScene(new Scene(fxmlCompras, 1280, 720));
//            stage.show();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void trocaTela(String scr) {
//        switch (scr) {
////            case "carrinho":
////                stage.setScene(carrinhoScene);
////                break;
//            case "compras":
//                stage.setScene(compraScene);
//        }
//    }
}
