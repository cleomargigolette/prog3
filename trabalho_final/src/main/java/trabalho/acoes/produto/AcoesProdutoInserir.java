/**
 * 
 */
package trabalho.acoes.produto;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.dao.ProdutoDAO;
import trabalho.dados.entidades.Fornecedor;
import trabalho.dados.entidades.Produto;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesProdutoInserir implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = new Produto();

		boolean fornecedorInvalido = true;

		do {

			System.out.println("--- Informe o id do Fornecedor desse Centro de Distribuição:");
			Integer idForncedor = Integer.valueOf(teclado.leString());

			Fornecedor fornecedor = fornecedorDAO.obter(idForncedor);

			if (fornecedor != null) {

				produto.setFornecedor(fornecedor);

				System.out.println("--- Informe o Valor do Produto:");
				produto.setValor(teclado.leDouble());

				System.out.println("--- Informe o Nome do Produto:");
				produto.setNome(teclado.leString());

				System.out.println("--- Informe o Código de Barras do Produto");
				produto.setCodigoBarras(teclado.leString());

				System.out.println("--- Informe o total em estoque:");
				produto.setTotalEstoque(teclado.leInt());

				produto.setAtivo(true);

				boolean inseriu = produtoDAO.insere(produto);

				String print = inseriu ? "--- Produto inserido com sucesso!" : "--- O novo Produto não foi inserido!";
				
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
