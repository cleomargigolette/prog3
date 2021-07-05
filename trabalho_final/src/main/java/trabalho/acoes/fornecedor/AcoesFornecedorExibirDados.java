/**
 * 
 */
package trabalho.acoes.fornecedor;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.Fornecedor;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesFornecedorExibirDados implements Acoes{

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		System.out.println("--- Informe o id do Fornecedor que deseja exibir dados:");
		int id = teclado.leInt();
		
		Fornecedor fornecedor = fornecedorDAO.obter(id);
		
		if(fornecedor == null) {
			
			System.out.println("--- O Fornecedor com este id não foi encontrado.");
			
		}else {
			
			String ativo = fornecedor.getAtivo() ? "Sim" : "Não";
			
			System.out.println();
			System.out.println("--- Id: " + fornecedor.getId());
			System.out.println("--- Nome: " + fornecedor.getNome());
			System.out.println("--- Ativo: " + ativo);
			System.out.println();
			
		}
	}

}
