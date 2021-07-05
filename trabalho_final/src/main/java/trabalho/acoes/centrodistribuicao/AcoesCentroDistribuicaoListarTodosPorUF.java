/**
 * 
 */
package trabalho.acoes.centrodistribuicao;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.CentroDistribuicaoDAO;
import trabalho.dados.entidades.CentroDistribuicao;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesCentroDistribuicaoListarTodosPorUF implements Acoes {

	@Override
	public void executar() {

		Teclado teclado = new Teclado();
		CentroDistribuicaoDAO centroDistribuicaoDAO = new CentroDistribuicaoDAO();

		System.out.println("--- Informe a UF que deseja listar os Centros de Distribuição:");
		String UF = teclado.leString();

		List<CentroDistribuicao> centrosDistribuicao = centroDistribuicaoDAO.listarPorUF(UF);

		this.printListaCentroDistribuicao(centrosDistribuicao);

	}

	private void printListaCentroDistribuicao(List<CentroDistribuicao> centrosDistribuicao) {

		if (centrosDistribuicao.isEmpty() == false) {

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

		} else {

			System.out.println("");
			System.out.println();
			System.out.println("--- Opss, essa UF não tem Centros de Distribuição cadastradas");
			System.out.println("");
			System.out.println("--- ###############################################################");

		}
	}

}
