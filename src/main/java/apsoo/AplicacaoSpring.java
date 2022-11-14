package apsoo;


import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("apsoo") //Procurar todos os beans de entidade
@SpringBootApplication
public class AplicacaoSpring {

	public static void main(String[] args) {
		Application.launch(AplicacaoJavaFx.class, args);
		//SpringApplication.run(AplicacaoSpring.class, args);

	}
}
