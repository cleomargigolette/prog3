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
public class AcoesProdutoExibirDados implements Acoes {

	@Override
	public void executar() {
		
		
		Teclado teclado = new Teclado();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		System.out.println("--- Informe o id do Produto que deseja exibir dados:");
		int id = teclado.leInt();
		
		Produto produto = produtoDAO.obter(id);
		
		if(produto == null) {
			
			System.out.println("--- O Produto com este id não foi encontrado.");
			
		}else {
			
			String ativo = produto.getAtivo() ? "Sim" : "Não";
			
			System.out.println();
			System.out.println("--- Id: " + produto.getId());
			System.out.println("--- Nome: " + produto.getNome());
			System.out.println("--- Valor: " + "R$"+ produto.getValor());
			System.out.println("--- Código de Barras: " + produto.getCodigoBarras());
			System.out.println("--- Total em Estoque: " + produto.getTotalEstoque());
			System.out.println("--- Nome do Fornecedor: " + produto.getFornecedor().getNome());
			System.out.println("--- Ativo: " + ativo);
			System.out.println();
			
		}
	}
}
