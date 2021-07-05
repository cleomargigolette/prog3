package trabalho.dados.dao;

import java.util.List;

public interface DAO<T> {

	//obtem um registro pelo id
	public T obter(int id);
	
	//obtem todos os registros
	public List<T> obterTodos();
	
	//insere um novo registro
	public boolean insere(T t);
	
	//atualiza um registro
	public boolean atualiza(T t);
	
	//deleta um registro
	public boolean deleta(T t);

}
