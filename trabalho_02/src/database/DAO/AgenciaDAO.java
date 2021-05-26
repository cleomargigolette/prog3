package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Agencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO implements DAO<Agencia> {

    private Connection connection;

    public AgenciaDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public Agencia obter(long id) {

        String sql = String.format("SELECT * FROM agencia WHERE id = %d", id);
        Agencia agencia = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                agencia = new Agencia();

                agencia.setId(result.getLong("id"));
                agencia.setCodigo(result.getString("codigo"));
                agencia.setNome(result.getString("nome"));
                agencia.setEndereco(result.getString("endereco"));
                agencia.setTelefone(result.getString("telefone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agencia;
    }

    @Override
    public List<Agencia> obterTodos() {

        String sql = String.format("SELECT * FROM agencia");
        List<Agencia> agencias = new ArrayList<Agencia>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Agencia agencia = new Agencia();

                agencia.setId(result.getLong("id"));
                agencia.setCodigo(result.getString("codigo"));
                agencia.setNome(result.getString("nome"));
                agencia.setEndereco(result.getString("endereco"));
                agencia.setTelefone(result.getString("telefone"));
                agencias.add(agencia);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agencias;
    }

    @Override
    public boolean insere(Agencia agencia) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO agencia (codigo, nome, endereco, telefone) ";
        sql = sql + "VALUES ('%s', '%s', '%s', '%s')";

        sql = String.format(
                sql,
                agencia.getCodigo(),
                agencia.getNome(),
                agencia.getEndereco(),
                agencia.getTelefone());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean atualiza(Agencia agencia) {

        int linhasModificadas = 0;

        String sql = "UPDATE agencia ";
        sql += "SET codigo = '%s', ";
        sql += "nome = '%s', ";
        sql += "telefone = '%s', ";
        sql += "endereco = '%s' ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                agencia.getCodigo(),
                agencia.getNome(),
                agencia.getTelefone(),
                agencia.getEndereco(),
                agencia.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(Agencia agencia) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM agencia WHERE id = %d";
        sql = String.format(sql, agencia.getId());

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

        String sql = "DELETE FROM agencia WHERE id >= 0";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;

    }
}
