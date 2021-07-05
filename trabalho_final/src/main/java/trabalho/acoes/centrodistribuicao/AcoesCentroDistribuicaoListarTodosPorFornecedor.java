/**
 * 
 */
package trabalho.acoes.centrodistribuicao;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.CentroDistribuicao;
import trabalho.dados.entidades.Fornecedor;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesCentroDistribuicaoListarTodosPorFornecedor implements Acoes {

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
				
				this.printListaCentroDsitribuicao(fornecedor.getCentrosDistribuicao());
				
				fornecedorInvalido = false;

			} else {
				
				System.out.println("-------------------------------------------------");
				System.out.println("--- O Fornecedor com este id não foi encontrado.");
				System.out.println("--- Vamos tentar novamente");
				System.out.println("-------------------------------------------------");
			}

		} while (fornecedorInvalido);

	}
	
	private void printListaCentroDsitribuicao(List<CentroDistribuicao> centrosDistribuicao) {
		
		if(centrosDistribuicao.isEmpty() == false) {
			
			centrosDistribuicao.forEach(centroDistribuicao -> {
				
				String ativo = centroDistribuicao.isAtivo() ? "Sim" : "Não";
				
				System.out.println("");
				System.out.println();
				System.out.println("--- Id: " + centroDistribuicao.getId());
				System.out.println("--- UF: " + centroDistribuicao.getUf());
				System.out.println("--- Cidade: " + centroDistribuicao.getCidade());
				System.out.println("--- Bairro: " + centroDistribuicao.getBairro());
				System.out.println("--- Rua: " + centroDistribuicao.getRua());
				System.out.println("--- Número: " + centroDistribuicao.getNumero());
				System.out.println("--- Complemento: " + centroDistribuicao.getComplemento());
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
