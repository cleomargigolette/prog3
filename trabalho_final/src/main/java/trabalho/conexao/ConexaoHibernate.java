package trabalho.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoHibernate {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		
		if(entityManager == null)
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("Loja");
			entityManager = entityManagerFactory.createEntityManager();
			return entityManager;
		}
		else
		{
			return entityManager;
		}
		
	}

}
