/**
 * 
 */
package trabalho.acoes.produto;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ProdutoDAO;
import trabalho.dados.entidades.Produto;

/**
 * @author cleomar
 *
 */
public class AcoesProdutoListarValorAcima50 implements Acoes {

	@Override
	public void executar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> produtos = produtoDAO.obterTodosValorAcima50();
		
		if(produtos.isEmpty() == true) {
			
			System.out.println("--- No momento não há Produtos com valor acima de R$50,00 reais cadastrados.");
			
		}else {
			
			produtos.forEach(produto -> {
				
				String ativo = produto.getAtivo()? "Sim" : "Não";
				
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
		}
	}

}
