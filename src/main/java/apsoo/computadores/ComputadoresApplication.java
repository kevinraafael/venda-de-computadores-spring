package apsoo.computadores;

import apsoo.computadores.domain.entity.Cliente;
import apsoo.computadores.domain.entity.Pessoa;
import apsoo.computadores.domain.repository.ClienteRepository;
import apsoo.computadores.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ComputadoresApplication implements CommandLineRunner {


	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(ComputadoresApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

//		Pessoa pessoa = new Pessoa();
//		pessoa.setCpf("11111132121");
//		pessoa.setNome("Fulano de Tal");
//		pessoa.setEndereco("UFMS");
//		pessoa.setTelefone("6799999999");
//
//		pessoaRepository.save(pessoa);
//
//
//		Cliente cliente = new Cliente();
//		cliente.setPessoa(pessoa);
//		clienteRepository.save(cliente);



//		Pagamento pag = new Pagamento();
//		pag.setTipoPagamento("pix");
//		pag.setValorTotal(100.0);
//		pag.setParcelamento(0);
//		pag.setDesconto(100.0);
//		pag.setValorTotal(900.00);
//		repository.save(pag);
	}
}
