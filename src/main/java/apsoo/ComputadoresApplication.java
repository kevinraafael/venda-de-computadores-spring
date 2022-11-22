package apsoo;

import apsoo.dao.*;
import apsoo.entity.*;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;
// Classe para fazer a Inserção no Banco
// Pode ser comentada após a primeira execução, pois se executada novamente ocasiona erro
//Por tentar adicionar uma pessoa com cpf já previamente cadastrado
@EntityScan("apsoo") //Procurar todos os beans de entidade
@SpringBootApplication
public class ComputadoresApplication implements CommandLineRunner {

	@Autowired
	private DevolucaoDao devolucaoDao;
	@Autowired
	private ItemVendaDao itemVendaDao;

	@Autowired
	private ComputadorDao computadorDao;

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
		//Application.launch(AplicacaoJavaFx.class, args);
		SpringApplication.run(ComputadoresApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("14317576082");
		pessoa.setNome("Carlos");
		pessoa.setEndereco("Nova Campo Grande");
		pessoa.setTelefone("991318961");

		pessoaRepository.save(pessoa);


		Funcionario funcionario = new Funcionario();
		funcionario.setComissao(17.6);
		funcionario.setPessoa(pessoa);
		funcionario.setMatricula("12365478999"); // não pode repetir
		funcionario.setPf_gerencia(true); // pq bolean
		funcionario.setData_contratacao(new Date(12));
		funcionarioDao.save(funcionario);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setCpf("00725766000");
        pessoa2.setNome("Kevin");
        pessoa2.setEndereco("Monte Castelo");
        pessoa2.setTelefone("992152185");
        pessoaRepository.save(pessoa2);

		Cliente cliente = new Cliente();
		cliente.setPessoa(pessoa2);
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

		Computador computador = new Computador();
		computador.setSo("Windows 11");
		computador.setArmazenamento("2TB");
		computador.setModelo("Desktop");
		computador.setProcessador("Intel i5 13600k");
		computador.setValor(7600.00);
		computador.setMemoria("32gb RAM");

		computadorDao.save(computador);

		Computador computador2 = new Computador();
		computador2.setSo("Windows 11");
		computador2.setArmazenamento("256gb");
		computador2.setModelo("Notebook");
		computador2.setProcessador("Intel i7 11Th");
        computador2.setValor(9600.00);
        computador2.setMemoria("16GB RAM");

        computadorDao.save(computador2);

		Computador computador3 = new Computador();
		computador3.setSo("Ubuntu");
		computador3.setArmazenamento("500GB");
		computador3.setModelo("Notebook");
		computador3.setProcessador("Intel i5 11Th");
		computador3.setValor(6600.00);
		computador3.setMemoria("8GB RAM");


		computadorDao.save(computador3);

		Computador computador4 = new Computador();
		computador4.setSo("Windows 11");
		computador4.setArmazenamento("500GB");
		computador4.setModelo("Desktop");
		computador4.setProcessador("Amd Ryzen 7 7700x");
		computador4.setValor(10500.00);
		computador4.setMemoria("64GB RAM");

		computadorDao.save(computador4);

		Computador computador5 = new Computador();
		computador5.setSo("Windows 10");
		computador5.setArmazenamento("500GB");
		computador5.setModelo("Desktop");
		computador5.setProcessador("Amd Ryzen 5600x");
		computador5.setValor(4600.0);
		computador5.setMemoria("16GB RAM");

		computadorDao.save(computador5);

		Computador computador6 = new Computador();
		computador6.setSo("Windows 11");
		computador6.setArmazenamento("2TB");
		computador6.setModelo("Desktop");
		computador6.setProcessador("Intel i9 13600k");
		computador6.setValor(26000.00);
		computador6.setMemoria("128GB RAM");

		computadorDao.save(computador6);

		ItemVenda itemVenda = ItemVenda.criaItem();
		itemVenda.setVenda(venda);
		itemVenda.setQtdVendida(1);
		itemVenda.setValorVendido(100);
		itemVenda.setComputador(computador);

		itemVendaDao.save(itemVenda);

		Devolucao devolucao = new Devolucao();
		devolucao.setItemVenda(itemVenda);
		devolucao.setFuncionario(funcionario);
		devolucao.setMotivo("Teste");
		devolucao.dataDevolucao(new java.util.Date());

		devolucaoDao.save(devolucao);
		devolucaoDao.findAll();




	}
}
