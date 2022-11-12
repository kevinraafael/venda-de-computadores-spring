package apsoo.computadores;


import apsoo.computadores.domain.controller.CarrinhosController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;


@Configuration
@SpringBootApplication

public class ComputadoresApplication extends Application {

	private static ConfigurableApplicationContext applicationContext;

	@Override
	public void init() throws Exception {
		this.applicationContext = SpringApplication.run(ComputadoresApplication.class);
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {



			try {


				FXMLLoader loader = new FXMLLoader(getClass().getResource("CarrinhoDeCompras.fxml"));

				loader.setControllerFactory(ComputadoresApplication.getApplicationContext()::getBean);

				Parent view =  (Parent) loader.load();
				stage.setScene(new Scene(view));

				//stage.initStyle(StageStyle.UNDECORATED);

				CarrinhosController controller = loader.getController();
				//controller.attachEvent();

				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	public static ConfigurableApplicationContext getApplicationContext() {
		return applicationContext;
	}
}