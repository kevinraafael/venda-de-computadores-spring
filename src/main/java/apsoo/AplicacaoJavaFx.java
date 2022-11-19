package apsoo;

import apsoo.controller.ItensCarrinhoController;
import javafx.application.Application;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

public class AplicacaoJavaFx extends Application {

    public static ConfigurableApplicationContext contextoSpring;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.contextoSpring = new SpringApplicationBuilder()
                .sources(AplicacaoSpring.class)
                .run(args);
    }

    @Override
    public void stop() {
        this.contextoSpring.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        FxWeaver fxWeaver = contextoSpring.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(ItensCarrinhoController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}