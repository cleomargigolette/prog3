package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Bandeira;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BandeiraDAO implements DAO<Bandeira> {

    private Connection connection;

    public BandeiraDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public Bandeira obter(long id) {

        String sql = String.format("SELECT * FROM bandeira WHERE id = %d", id);
        Bandeira bandeira = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                bandeira = new Bandeira();

                bandeira.setId(result.getLong("id"));
                bandeira.setDescricao(result.getString("descricao"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bandeira;
    }

    @Override
    public List<Bandeira> obterTodos() {

        String sql = String.format("SELECT * FROM bandeira");
        List<Bandeira> bandeiras = new ArrayList<Bandeira>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Bandeira bandeira = new Bandeira();

                bandeira.setId(result.getLong("id"));
                bandeira.setDescricao(result.getString("descricao"));
                bandeiras.add(bandeira);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bandeiras;
    }

    @Override
    public boolean insere(Bandeira bandeira) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO bandeira (descricao) ";
        sql = sql + "VALUES ('%s')";

        sql = String.format(
                sql,
                bandeira.getDescricao());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean atualiza(Bandeira bandeira) {

        int linhasModificadas = 0;

        String sql = "UPDATE bandeira ";
        sql += "SET descricao = '%s' ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                bandeira.getDescricao(),
                bandeira.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(Bandeira bandeira) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM bandeira WHERE id = %d";
        sql = String.format(sql, bandeira.getId());

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

        String sql = "DELETE FROM bandeira WHERE id >= 0";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }
}
