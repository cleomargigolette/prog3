/**
 * 
 */
package trabalho.acoes.contato;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ContatoDAO;
import trabalho.dados.entidades.Contato;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesContatoExibirDados implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		ContatoDAO contatoDAO = new ContatoDAO();
		
		System.out.println("--- Informe o Contato que deseja exibir dados:");
		int id = teclado.leInt();
		
		Contato contato = contatoDAO.obter(id);
		
		if(contato == null) {
			
			System.out.println("--- O Contato com este id não foi encontrado.");
			
		}else {
			
			String ativo = contato.isAtivo() ? "Sim" : "Não";
			
			System.out.println();
			System.out.println("--- Id: " + contato.getId());
			System.out.println("--- Tipo: " + contato.getTipo());
			System.out.println("--- Descrição: " + contato.getDescricao());
			System.out.println("--- Nome do Fornecedor: " + contato.getFornecedor().getNome());
			System.out.println("--- Ativo: " + ativo);
			System.out.println();
			
		}
	}

}
