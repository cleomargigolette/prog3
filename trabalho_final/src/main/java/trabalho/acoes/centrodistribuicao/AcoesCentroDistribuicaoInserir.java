/**
 * 
 */
package trabalho.acoes.centrodistribuicao;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.CentroDistribuicaoDAO;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.CentroDistribuicao;
import trabalho.dados.entidades.Fornecedor;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesCentroDistribuicaoInserir implements Acoes {

	@Override
	public void executar() {

		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		CentroDistribuicaoDAO centroDistribuicaoDAO = new CentroDistribuicaoDAO();
		CentroDistribuicao centroDistribuicao = new CentroDistribuicao();

		boolean fornecedorInvalido = true;

		do {

			System.out.println("--- Informe o id do Fornecedor desse Centro de Distribuição:");
			Integer idForncedor = Integer.valueOf(teclado.leString());

			Fornecedor fornecedor = fornecedorDAO.obter(idForncedor);

			if (fornecedor != null) {

				centroDistribuicao.setFornecedor(fornecedor);

				System.out.println("--- Informe a UF do centroDistribuicao:");
				centroDistribuicao.setUf(teclado.leString());

				System.out.println("--- Informe a Cidade do centroDistribuicao:");
				centroDistribuicao.setCidade(teclado.leString());

				System.out.println("--- Informe o Bairro do centroDistribuicao:");
				centroDistribuicao.setBairro(teclado.leString());

				System.out.println("--- Informe a Rua do centroDistribuicao:");
				centroDistribuicao.setRua(teclado.leString());

				System.out.println("--- Informe o Número do centroDistribuicao:");
				centroDistribuicao.setNumero(teclado.leInt());

				System.out.println("--- Informe o Complemento do centroDistribuicao:");
				centroDistribuicao.setComplemento(teclado.leString());

				centroDistribuicao.setAtivo(true);

				boolean inseriu = centroDistribuicaoDAO.insere(centroDistribuicao);

				String print = inseriu ? "--- CentroDistribuicao inserido com sucesso!" : "--- O novo CentroDistribuicao não foi inserido!";
				System.out.println(print);
				
				fornecedorInvalido = false;

			} else {
				
				System.out.println("-------------------------------------------------");
				System.out.println("--- O Fornecedor com este id não foi encontrado.");
				System.out.println("--- Vamos tentar novamente");
				System.out.println("-------------------------------------------------");
			}

		} while (fornecedorInvalido);

	}

}
