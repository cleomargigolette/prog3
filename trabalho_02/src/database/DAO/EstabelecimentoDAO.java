package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Estabelecimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoDAO implements DAO<Estabelecimento> {

    private Connection connection;

    public EstabelecimentoDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public Estabelecimento obter(long id) {

        String sql = String.format("SELECT * FROM estabelecimento WHERE id = %d", id);
        Estabelecimento estabelecimento = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                estabelecimento = new Estabelecimento();

                estabelecimento.setId(result.getLong("id"));
                estabelecimento.setNome(result.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estabelecimento;
    }

    @Override
    public List<Estabelecimento> obterTodos() {

        String sql = String.format("SELECT * FROM estabelecimento");
        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Estabelecimento estabelecimento = new Estabelecimento();

                estabelecimento.setId(result.getLong("id"));
                estabelecimento.setNome(result.getString("nome"));
                estabelecimentos.add(estabelecimento);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return estabelecimentos;
    }

    @Override
    public boolean insere(Estabelecimento estabelecimento) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO estabelecimento (nome) ";
        sql = sql + "VALUES ('%s')";

        sql = String.format(
                sql,
                estabelecimento.getNome());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean atualiza(Estabelecimento estabelecimento) {

        int linhasModificadas = 0;

        String sql = "UPDATE estabelecimento ";
        sql += "SET nome = '%s' ";
        sql += "WHERE id = %d";

        sql = String.format(sql,
                estabelecimento.getNome(),
                estabelecimento.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(Estabelecimento estabelecimento) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM estabelecimento WHERE id = %d";
        sql = String.format(sql, estabelecimento.getId());

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deletaTodos() {

        int linhasModificadas = 0;

        String sql = "DELETE FROM pessoafisica WHERE id >= 0";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }
}
