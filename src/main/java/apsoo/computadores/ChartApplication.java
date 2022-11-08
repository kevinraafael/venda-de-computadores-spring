package apsoo.computadores;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

public class ChartApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(MainApplication.class).run();
    }

    @Override
    public void start(Stage primeiroStage) {
        applicationContext.publishEvent(new StageReadyEvent(primeiroStage));

    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage primeiroStage) {
            super(primeiroStage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}
