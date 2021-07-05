/**
 * 
 */
package trabalho.acoes.centrodistribuicao;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.CentroDistribuicaoDAO;
import trabalho.dados.entidades.CentroDistribuicao;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesCentroDistribuicaoExibirDados implements Acoes{

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		CentroDistribuicaoDAO centroDistribuicaoDAO = new CentroDistribuicaoDAO();
		
		System.out.println("--- Informe o id do Centro de Distribuição que deseja exibir dados:");
		int id = teclado.leInt();
		
		CentroDistribuicao centroDistribuicao = centroDistribuicaoDAO.obter(id);
		
		if(centroDistribuicao == null) {
			
			System.out.println("--- O Centro de Distribuição com este id não foi encontrado.");
			
		}else {
			
			String ativo = centroDistribuicao.isAtivo() ? "Sim" : "Não";
			
			System.out.println();
			System.out.println("--- Id: " + centroDistribuicao.getId());
			System.out.println("--- UF: " + centroDistribuicao.getUf());
			System.out.println("--- Cidade: " + centroDistribuicao.getCidade());
			System.out.println("--- Bairro: " + centroDistribuicao.getBairro());
			System.out.println("--- Rua: " + centroDistribuicao.getRua());
			System.out.println("--- Número: " + centroDistribuicao.getNumero());
			System.out.println("--- Complemento: " + centroDistribuicao.getComplemento());
			System.out.println("--- Ativo: " + ativo);
			System.out.println();
			
		}
	}

}
