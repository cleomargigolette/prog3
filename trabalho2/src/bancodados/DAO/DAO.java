package bancodados.DAO;

import java.util.List;

public interface DAO<T>{

    public T obter(long id);

    public List<T> obterTodos();

    public boolean insert(T t);

    public boolean atualizar(T t);

    public boolean deleta(T t);

    public boolean deletaTodos();
}
