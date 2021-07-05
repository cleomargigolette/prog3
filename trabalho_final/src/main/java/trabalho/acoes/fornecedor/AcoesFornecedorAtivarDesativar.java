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
public class AcoesFornecedorAtivarDesativar implements Acoes {

	@Override
	public void executar() {

		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		boolean atualizado = false;

		System.out.println();
		System.out.println("--- Informe o id do Fornecedor que deseja Ativar ou Desativar:");
		int id = teclado.leInt();

		Fornecedor fornecedor = fornecedorDAO.obter(id);

		if (fornecedor == null) {

			System.out.println("--- O Fornecedor com este id não foi encontrado.");

		} else {

			boolean opcaoInvalida = true;

			do {

				System.out.println("--- Escolha uma opção para o Fornecedor:");
				System.out.println("--- 1 = Ativar");
				System.out.println("--- 2 = Desativar");
				int desicao = teclado.leInt();

				switch (desicao) {
				case 1:

					fornecedor.setAtivo(true);
					opcaoInvalida = false;

					break;

				case 2:
					fornecedor.setAtivo(false);
					opcaoInvalida = false;

					break;

				default:

					System.out.println();
					System.out.println("--- Opção inválida!!!");
					System.out.println("--- Tente novamente.");
					System.out.println();

					break;

				}

			} while (opcaoInvalida);
			
			atualizado = fornecedorDAO.atualiza(fornecedor);
			
			String print = atualizado ? "--- Fornecedor atualizado com sucesso." : "--- Desculpe, mas não foi possível ativar esse Fornecedor.";

			System.out.println(print);
		
		}
	}

}
