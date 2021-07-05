/**
 * 
 */
package trabalho.acoes.produto;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ProdutoDAO;
import trabalho.dados.entidades.Produto;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesProdutoAtualizar implements Acoes {

	@Override
	public void executar() {
	
		Teclado teclado = new Teclado();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		System.out.println();

		System.out.println("--- Informe o id do Produto que deseja atualizar:");
		int id = teclado.leInt();

		Produto produto = produtoDAO.obter(id);

		if (produto == null) {

			System.out.println("--- O Produto com este id não foi encontrado.");

		} else {

			System.out.println("--- Informe o Valor do Produto:");
			produto.setValor(teclado.leDouble());

			System.out.println("--- Informe o Nome do Produto:");
			produto.setNome(teclado.leString());

			System.out.println("--- Informe o Código de Barras do Produto");
			produto.setCodigoBarras(teclado.leString());

			System.out.println("--- Informe o total em estoque:");
			produto.setTotalEstoque(teclado.leInt());

			boolean atualizou = produtoDAO.atualiza(produto);
			
			String print = atualizou ? "--- Produto foi atualizado com sucesso!" : "--- O Produto não foi atualizado!";

			System.out.println(print);

		}
	}

}
