package bancodados.DAO;

import java.util.List;

public class PessoaFisicaDAO implements DAO<PessoaFisicaDAO>{

    @Override
    public PessoaFisicaDAO obter(long id) {
        return null;
    }

    @Override
    public List<PessoaFisicaDAO> obterTodos() {
        return null;
    }

    @Override
    public boolean insert(PessoaFisicaDAO pessoaFisicaDAO) {
        return false;
    }

    @Override
    public boolean atualizar(PessoaFisicaDAO pessoaFisicaDAO) {
        return false;
    }

    @Override
    public boolean deleta(PessoaFisicaDAO pessoaFisicaDAO) {
        return false;
    }

    @Override
    public boolean deletaTodos() {
        return false;
    }
}
