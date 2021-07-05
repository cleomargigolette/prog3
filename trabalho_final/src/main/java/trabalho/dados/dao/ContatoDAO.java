package trabalho.dados.dao;

import java.util.List;

import javax.persistence.EntityManager;

import trabalho.conexao.ConexaoHibernate;
import trabalho.dados.entidades.Contato;
import trabalho.dominio.TipoContato;

@SuppressWarnings("unchecked")
public class ContatoDAO implements DAO<Contato> {

	public static EntityManager entityManager;

	public ContatoDAO() {

		entityManager = ConexaoHibernate.getEntityManager();
	}

	public Contato obter(int id) {

		Contato contato = entityManager.find(Contato.class, id);

		return contato;
	}

	public List<Contato> obterTodos() {

		List<Contato> contatos = null;

		try {

			contatos = entityManager.createQuery("from Contato").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return contatos;
	}

	public boolean insere(Contato t) {

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

	public boolean atualiza(Contato t) {

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

	public boolean deleta(Contato t) {

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

	public boolean deletaTodos() {

		int modificadas = 0;

		try {

			modificadas = entityManager.createQuery("delete from Contato where id >= 0").executeUpdate();

		} catch (Exception e) {

			return false;
		}

		return modificadas > 0 ? true : false;
	}

	public List<Contato> listarPorTipo(TipoContato tipoContato) {
		
		List<Contato> contatos = null;

		try {

			String query = "select c from Contato c where c.tipo = "+tipoContato.ordinal();
			contatos = entityManager.createQuery(query).getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return contatos;
	}

}
