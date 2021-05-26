import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import database.DAO.*;
import database.entities.*;

public class Boot {

	public static void main(String[] args) {
		
		PessoaFisicaDAO pessoasDAO = new PessoaFisicaDAO();
		ContaDAO contasDAO = new ContaDAO();
		AgenciaDAO agenciaDAO = new AgenciaDAO();
		BandeiraDAO bandeiraDAO = new BandeiraDAO();
		CartaoDAO cartaoDAO = new CartaoDAO();
		EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
		FaturaDAO faturaDAO = new FaturaDAO();
		GerenteDAO gerenteDAO = new GerenteDAO();
		MovimentoCartaoDAO movimentoCartaoDAO = new MovimentoCartaoDAO();

		boolean retorno = false;

		/* obtendo uma pessoa do banco (e exibindo na tela seu nome)*/

		PessoaFisica pessoaObtida = pessoasDAO.obter(3);
		System.out.println(pessoaObtida.getNome());

		/* obtendo todas as pessoas do banco (e exibindo os nomes na tela) */

		List<PessoaFisica> pessoas = pessoasDAO.obterTodos();

		System.out.println(pessoas.size());

		for (PessoaFisica pessoaFisica : pessoas) {
			System.out.println(pessoaFisica.getNome());
		}

		/* inserindo uma nova pessoa no banco */

		PessoaFisica novaPessoa = new PessoaFisica();
		novaPessoa.setNome("Tiago");
		novaPessoa.setEndereco("Rua dos Bobos, n�mero 0");
		novaPessoa.setNascimento(LocalDate.of(1981, 11, 15));
		novaPessoa.setSexo("M");
		novaPessoa.setEmail("tkautzmann@gmail.com");
		novaPessoa.setTelefone("51 996002114");
		novaPessoa.setCpf("00217622736");

		retorno = pessoasDAO.insere(novaPessoa);

		System.out.println(retorno);

		/* atualizando o nome e o e-mail de uma pessoa no banco (ap�s obt�-la do banco) */

		PessoaFisica pessoa = pessoasDAO.obter(4);

		pessoa.setNome("MANOEL MOREIRA");
		pessoa.setEmail("manoel@gmail.com");

		retorno = pessoasDAO.atualiza(pessoa);

		System.out.println(retorno);

		/* excluindo uma pessoa do banco (ap�s obt�-la do banco) */
//
//		//PessoaFisica pessoaParaExcluir = pessoasDAO.obter(12);
//
//		//retorno = pessoasDAO.deleta(pessoaParaExcluir);
//
//		//System.out.println(retorno);
//
//		/* excluindo todas as pessoas do banco */
//
//		//retorno = pessoasDAO.deletaTodos();
//
//		//System.out.println(retorno);

		/* obtendo uma conta do banco (e exibindo na tela o saldo e o limite da conta)*/

		Conta contaObtida = contasDAO.obter(2);
		System.out.println(contaObtida.getSaldo());
		System.out.println(contaObtida.getLimite());

		/* obtendo a pessoa da conta rec�m obtida (e exibindo na tela o nome da pessoa)*/

		PessoaFisica pessoaDaConta = pessoasDAO.obter(contaObtida.getIdPessoaFisica());
		System.out.println(pessoaDaConta.getNome());

		/* inserindo uma nova conta no banco */

		Conta novaConta = new Conta();
		novaConta.setLimite(1700F);
		novaConta.setSaldo(0F);
		novaConta.setNumero("66011");
		novaConta.setIdagencia(1);
		novaConta.setIdgerente(2);
		novaConta.setIdPessoaFisica(7);

		retorno = contasDAO.insere(novaConta);

		System.out.println(retorno);

		/* obtendo todas as agencias do banco (e exibindo os nomes na tela) */

		List<Agencia> agencias = agenciaDAO.obterTodos();

		System.out.println(agencias.size());

		for (Agencia agencia : agencias) {
			System.out.println(agencia.getNome());
		}

		/* obtendo um agencia pelo id (e exibindo o nome e telefone na tela) */

		Agencia agencia = agenciaDAO.obter(4);

		System.out.println(agencia.getNome());
		System.out.println(agencia.getTelefone());

		/* Inserinfo um agencia*/

		Agencia newAgencia = new Agencia();
		newAgencia.setCodigo("000089");
		newAgencia.setNome("Guarani 1");
		newAgencia.setEndereco("Rua dos Joaquin Pedro Soares, numero 20");
		newAgencia.setTelefone("51 996002114");

		retorno = agenciaDAO.insere(newAgencia);

		System.out.println(retorno);

		/* atualizando o nome e o código de uma agencia no banco (após obte-la do banco) */

		Agencia agencia1 = agenciaDAO.obter(1);

		agencia1.setNome("Guarani 2");
		agencia1.setCodigo("000090");

		retorno = agenciaDAO.atualiza(agencia1);

		System.out.println(retorno);

		/* excluindo uma agencia do banco (após obtê-la do banco) */

//		Agencia agenciaParaExcluir = agenciaDAO.obter(1);
//
//		retorno = agenciaDAO.deleta(agenciaParaExcluir);
//
//		System.out.println(retorno);

		/*Obter todas as bandeiras e print na tela a descrição */

		List<Bandeira> bandeiras = bandeiraDAO.obterTodos();

		bandeiras.forEach(bandeira -> {
			System.out.println(bandeira.getDescricao());
		});

		/*Obter bandeira pelo id e print na tela a descrição */

		Bandeira bandeira = bandeiraDAO.obter(1);

		System.out.println(bandeira.getDescricao());

		/* Inseri uma nova bandeira */

		Bandeira newBandeira = new Bandeira();

		newBandeira.setDescricao("Nova");

		retorno = bandeiraDAO.insere(newBandeira);

		System.out.println(retorno);

		/*Atualizando uma descrição de uma bandeira*/
		Bandeira bandeira3 = bandeiraDAO.obter(1);

		bandeira3.setDescricao("Atualizada");

		retorno = bandeiraDAO.atualiza(bandeira3);

		System.out.println(retorno);

		/* excluindo uma bandeira do banco (após obtê-la do banco) */
//
//		Bandeira bandeira1ParaExcluir = bandeiraDAO.obter(6);
//
//		retorno = bandeiraDAO.deleta(bandeira1ParaExcluir);
//
//		System.out.println(retorno);

		/*Obter todas os cartões e print na tela o numero e limite */

		List<Cartao> cartoes = cartaoDAO.obterTodos();

		cartoes.forEach(cartao -> {
			System.out.println(cartao.getNumero());
			System.out.println(cartao.getLimite());
		});

		/*Obter cartao pelo id e print na tela o numero e limite */

		Cartao cartao = cartaoDAO.obter(12l);

		System.out.println(cartao.getNumero());
		System.out.println(cartao.getDiaVencimento());
		System.out.println(cartao.getLimite());

		/* Inseri um novo cartao */

		Cartao newCartao = new Cartao();

		newCartao.setIdbandeira(1l);
		newCartao.setIdconta(1l);
		newCartao.setDiaVencimento(5);
		newCartao.setLimite(8500.0);
		newCartao.setNumero("1234567890123456");

		retorno = cartaoDAO.insere(newCartao);

		System.out.println(retorno);

		/* atualizando o limite e dia de vencimento de um cartao no banco (após obte-la do banco) */

		Cartao cartao2 = cartaoDAO.obter(12);

		cartao2.setLimite(9000.0);
		cartao2.setDiaVencimento(10);

		retorno = cartaoDAO.atualiza(cartao2);

		System.out.println(retorno);

		/*Obtendo todos os estabelecimentos do banco e exibindo o nome*/

		List<Estabelecimento> estabelecimentos = estabelecimentoDAO.obterTodos();

		estabelecimentos.forEach(estabelecimento -> {
			System.out.println(estabelecimento.getNome());
		});

		/*Obtendo estabelecimento pelo id do banco e exibindo o nome*/

		Estabelecimento estabelecimento = estabelecimentoDAO.obter(1l);

		System.out.println(estabelecimento.getNome());

		/*Inserindo um novo estabelecimento*/

		Estabelecimento newEstabelecimento = new Estabelecimento();

		newEstabelecimento.setNome("Fornadas Pizza");

		retorno = estabelecimentoDAO.insere(newEstabelecimento);

		System.out.println(retorno);

		/*Atualizando o nome de um estabelecimento*/

		Estabelecimento estabelecimento1 = estabelecimentoDAO.obter(10);
		estabelecimento1.setNome("Atualizado");

		retorno = estabelecimentoDAO.atualiza(estabelecimento1);

//		/*Deletar um estabelecimento pelo id*/
//
//		Estabelecimento estabelecimentoParaExcluir = estabelecimentoDAO.obter(10);
//
//		retorno = estabelecimentoDAO.deleta(estabelecimentoParaExcluir);


		/*Obter todas faturas e imprime na tela valor e vencimento*/

		List<Fatura> faturas = faturaDAO.obterTodos();

		faturas.forEach(fatura -> {
			System.out.println(fatura.getValor());
			System.out.println(fatura.getVencimento());
		});

		/*obter fatura pelo id e printar na tela valor e  vencimento*/

		Fatura fatura = faturaDAO.obter(2l);

		System.out.println(fatura.getValor());
		System.out.println(fatura.getVencimento());

		/*inserir uma nova fatura*/

		Fatura fatura1 = new Fatura();

		fatura1.setIdcartao(1l);
		fatura1.setValorpago(123.33);
		fatura1.setValorminimo(123.33);
		fatura1.setValor(123.33);
		fatura1.setDatapagamento(LocalDateTime.now());
		fatura1.setVencimento(LocalDateTime.now());

		retorno = faturaDAO.insere(fatura1);

//		System.out.println(retorno);

		/*atualizar valor da fatura*/

		Fatura fatura2 = faturaDAO.obter(9l);

		fatura2.setValor(1000.00);

		retorno = faturaDAO.atualiza(fatura2);

		System.out.println(retorno);

		/*Deletar fatura depois de buscar pelo id*/
//
//		Fatura faturaParaExcluir = faturaDAO.obter(1);
//
//		retorno = faturaDAO.deleta(faturaParaExcluir);
//
//		System.out.println(retorno);

		/*Obter um gerente no banco buscando pelo id e printando na tela nome e cpf*/

		Gerente gerente = gerenteDAO.obter(1l);

		System.out.println(gerente.getNome());
		System.out.println(gerente.getCpf());



		/*Inserindo um novo gerente no banco*/
		Gerente newGerente = new Gerente();

		newGerente.setMatricula("0005");
		newGerente.setNome("Cleomar Gigolette da Silva");
		newGerente.setCpf("02611487698");
		newGerente.setSexo("M");

		retorno = gerenteDAO.insere(newGerente);

		/*Atualizando um gerente do banco depois de buscar o mesmo pelo id*/
		Gerente gerenteUpdate = gerenteDAO.obter(2);

		gerenteUpdate.setNome("Nome de teste de update");

		retorno = gerenteDAO.atualiza(gerenteUpdate);

		/*Deletando um gerente depois de buscar o mesmo pelo id*/
//
//		Gerente gerenteParaExcluir = gerenteDAO.obter(1);
//
//		retorno = gerenteDAO.deleta(gerenteParaExcluir);

		/*Obtendo todos os gerentes do banco e printando na tela nome e cpf de cada um*/

		List<Gerente> gerenteList = gerenteDAO.obterTodos();

		gerenteList.forEach(gerenteFor -> {
			System.out.println(gerenteFor.getNome());
			System.out.println(gerenteFor.getCpf());
		});

		/*Obter um movimento de cartao do bando pelo id*/

		MovimentoCartao movimentoCartao = movimentoCartaoDAO.obter(1);

		System.out.println(movimentoCartao.getValor());

		/*Inserir um movimento de cartão */

		MovimentoCartao newMovimentoCartao = new MovimentoCartao();

		newMovimentoCartao.setData(LocalDateTime.now());
		newMovimentoCartao.setValor(1203.3);
		newMovimentoCartao.setIdfatura(4);
		newMovimentoCartao.setIdcartao(4);
		newMovimentoCartao.setIdestabelecimento(4);

		retorno = movimentoCartaoDAO.insere(newMovimentoCartao);

		/*Atualiza um movimento de cartão depois de buscar o mesmo do banco*/

		MovimentoCartao movimentoCartao3 = movimentoCartaoDAO.obter(24);

		movimentoCartao3.setValor(000.0);
		movimentoCartao3.setIdfatura(3);

		retorno = movimentoCartaoDAO.atualiza(movimentoCartao3);

		/*Obter todos os movimentos de cartões e printar na tela valor e data*/

		List<MovimentoCartao> movimentoCartaoList = movimentoCartaoDAO.obterTodos();

		movimentoCartaoList.forEach(movimentoCartao1 -> {
			System.out.println(movimentoCartao1.getValor());
			System.out.println(movimentoCartao1.getData());
		});

		/*Exclui um movimento do banco*/

//		MovimentoCartao movimentoCartaoParaExcluir = movimentoCartaoDAO.obter(4);
//
//		retorno = movimentoCartaoDAO.deleta(movimentoCartaoParaExcluir);
	}


}
