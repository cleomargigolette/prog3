/**
 * 
 */
package trabalho.acoes.produto;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.Fornecedor;
import trabalho.dados.entidades.Produto;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesProdutoListarTodosPorFornecedor implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		boolean fornecedorInvalido = true;

		do {

			System.out.println("--- Informe o id do Fornecedor desse Centro de Distribuição:");
			Integer idForncedor = Integer.valueOf(teclado.leString());

			Fornecedor fornecedor = fornecedorDAO.obter(idForncedor);

			if (fornecedor != null) {
				
				this.printListaProdutos(fornecedor.getProdutos());
				
				fornecedorInvalido = false;

			} else {
				
				System.out.println("-------------------------------------------------");
				System.out.println("--- O Fornecedor com este id não foi encontrado.");
				System.out.println("--- Vamos tentar novamente");
				System.out.println("-------------------------------------------------");
			}

		} while (fornecedorInvalido);

	}
	
	private void printListaProdutos(List<Produto> produtos) {
		
		if(produtos.isEmpty() == false) {
			
			produtos.forEach(produto -> {
				
				String ativo = produto.getAtivo() ? "Sim" : "Não";
				
				System.out.println("");
				System.out.println();
				System.out.println("--- Id: " + produto.getId());
				System.out.println("--- Nome: " + produto.getNome());
				System.out.println("--- Valor: " + "R$"+ produto.getValor());
				System.out.println("--- Código de Barras: " + produto.getCodigoBarras());
				System.out.println("--- Total em Estoque: " + produto.getTotalEstoque());
				System.out.println("--- Nome do Fornecedor: " + produto.getFornecedor().getNome());
				System.out.println("--- Ativo: " + ativo);
				System.out.println("");
				System.out.println("--- ###############################################################");
				
			});
			
		}else {
			
			System.out.println("");
			System.out.println();
			System.out.println("--- Opss, esse Fornecedor não possui centros de distribuição cadastrado." );
			System.out.println("");
			System.out.println("--- ###############################################################");
			
		}
		
	}

}
