/**
 * 
 */
package trabalho.dados.dao;

import java.util.List;

import javax.persistence.EntityManager;

import trabalho.conexao.ConexaoHibernate;
import trabalho.dados.entidades.PedidoProduto;

/**
 * @author cleomar
 *
 */
@SuppressWarnings("unchecked")
public class PedidoProdutoDAO implements DAO<PedidoProduto>{
	
	public static EntityManager entityManager;

	public PedidoProdutoDAO() {
		entityManager = ConexaoHibernate.getEntityManager();
	}

	@Override
	public PedidoProduto obter(int id) {
		
		PedidoProduto pedidoProduto = entityManager.find(PedidoProduto.class, id);

		return pedidoProduto;
	}
	
	@Override
	public List<PedidoProduto> obterTodos() {
		
		List<PedidoProduto> pedidosProduto = null;

		try {

			pedidosProduto = entityManager.createQuery("from PedidoProduto").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return pedidosProduto;
	}

	@Override
	public boolean insere(PedidoProduto t) {
		
		try {

			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

		return true;
	}

	@Override
	public boolean atualiza(PedidoProduto t) {
		
		try {

			entityManager.getTransaction().begin();
			entityManager.merge(t);
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

		return true;
	}

	@Override
	public boolean deleta(PedidoProduto t) {
		
		try {

			entityManager.getTransaction().begin();
			entityManager.remove(t);
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

		return true;
	}

}
