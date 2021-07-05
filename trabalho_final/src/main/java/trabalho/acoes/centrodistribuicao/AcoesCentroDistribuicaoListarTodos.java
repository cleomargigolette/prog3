/**
 * 
 */
package trabalho.acoes.centrodistribuicao;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.CentroDistribuicaoDAO;
import trabalho.dados.entidades.CentroDistribuicao;

/**
 * @author cleomar
 *
 */
public class AcoesCentroDistribuicaoListarTodos implements Acoes {

	@Override
	public void executar() {
		
		CentroDistribuicaoDAO centroDistribuicaoDAO = new CentroDistribuicaoDAO();
		
		List<CentroDistribuicao> centrosDistribuicao = centroDistribuicaoDAO.obterTodos();
		
		if(centrosDistribuicao.isEmpty() == true) {
			
			System.out.println("--- No momento não há Centros de Distribuição cadastrados.");
			
		}else {
			
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
		}

	}

}
