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
public class AcoesFornecedorAtualizar implements Acoes{

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		System.out.println();

		System.out.println("--- Informe o id do Fornecedor que deseja atualizar:");
		int id = teclado.leInt();

		Fornecedor fornecedor = fornecedorDAO.obter(id);

		if (fornecedor == null) {

			System.out.println("--- O Fornecedor com este id não foi encontrado.");

		} else {

			System.out.println("--- Informe um novo nome para o Fornecedor");
			fornecedor.setNome(teclado.leString());

			boolean atualizou = fornecedorDAO.atualiza(fornecedor);
			
			String print = atualizou ? "--- Fornecedor foi atualizado com sucesso!" : "--- O Fornecedor não foi atualizado!";

			System.out.println(print);

		}
		
	}

}
