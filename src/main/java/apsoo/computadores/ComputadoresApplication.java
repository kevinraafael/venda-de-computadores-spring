package apsoo.computadores;

import apsoo.computadores.domain.dao.*;
import apsoo.computadores.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;


@SpringBootApplication
public class ComputadoresApplication implements CommandLineRunner {


	@Autowired
	private PessoaDao pessoaRepository;

	@Autowired
	private ClienteDao clienteRepository;


	@Autowired
	private PagamentoDao pagamentorDao;

	@Autowired
	private VendaDao vendaDao;
	@Autowired
	FuncionarioDao funcionarioDao;
	public static void main(String[] args) {
		SpringApplication.run(ComputadoresApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("14785236987");
		pessoa.setNome("Fulano de Tal");
		pessoa.setEndereco("UFMS");
		pessoa.setTelefone("6799999999");

		pessoaRepository.save(pessoa);

		Funcionario funcionario = new Funcionario();
		funcionario.setComissao(17.6);
		funcionario.setPessoa(pessoa);
		funcionario.setMatricula("12365478999"); // não pode repetir
		funcionario.setPf_gerencia(true); // pq bolean
		funcionario.setData_contratacao(new Date(12));
		funcionarioDao.save(funcionario);



		Cliente cliente = new Cliente();
		cliente.setPessoa(pessoa);
		clienteRepository.save(cliente);



		Pagamento pag = new Pagamento();
		pag.setTipoPagamento("pix");
		pag.setValorTotal(100.0);
		pag.setParcelamento(0);
		pag.setDesconto(100.0);
		pag.setValorTotal(900.00);
		pagamentorDao.save(pag);


		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setCodigo(1456987);
		venda.setFuncionario(funcionario);
		venda.setFormaPagemnto(pag);
		venda.setValor(100.75);
		vendaDao.save(venda);


	}
}
