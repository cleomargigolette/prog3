/**
 * 
 */
package trabalho.dados.dao;

import java.util.List;

import javax.persistence.EntityManager;

import trabalho.conexao.ConexaoHibernate;
import trabalho.dados.entidades.Produto;

/**
 * @author cleomar
 *
 */
@SuppressWarnings("unchecked")
public class ProdutoDAO implements DAO<Produto>{
	
	public static EntityManager entityManager;

	public ProdutoDAO() {
		entityManager = ConexaoHibernate.getEntityManager();
	}

	@Override
	public Produto obter(int id) {
		
		Produto produto = entityManager.find(Produto.class, id);

		return produto;
	}

	@Override
	public List<Produto> obterTodos() {
		
		List<Produto> produtos = null;

		try {

			produtos = entityManager.createQuery("from Produto").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return produtos;
	}

	@Override
	public boolean insere(Produto t) {
		
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
	public boolean atualiza(Produto t) {
		
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
	public boolean deleta(Produto t) {
		
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

	public List<Produto> obterTodosValorAcima50() {
		
		List<Produto> produtos = null;
		
		double valor = 50;

		try {

			produtos = entityManager.createQuery("Select p from Produto p where p.valor >" + valor).getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return produtos;
	}

}
