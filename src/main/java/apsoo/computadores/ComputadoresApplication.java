package apsoo.computadores;

import apsoo.computadores.domain.repository.PessoaRepository;
import apsoo.computadores.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ComputadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputadoresApplication.class, args);

	}
}
