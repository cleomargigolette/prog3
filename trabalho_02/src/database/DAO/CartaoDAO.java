package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Cartao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartaoDAO implements DAO<Cartao> {

    private Connection connection;

    public CartaoDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public Cartao obter(long id) {

        String sql = String.format("SELECT * FROM cartao WHERE id = %d", id);
        Cartao cartao = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                cartao = new Cartao();

                cartao.setId(result.getLong("id"));
                cartao.setNumero(result.getString("numero"));
                cartao.setLimite(result.getLong("limite"));
                cartao.setDiaVencimento(result.getInt("diaVencimento"));
                cartao.setIdconta(result.getLong("idconta"));
                cartao.setIdbandeira(result.getLong("idbandeira"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartao;
    }

    @Override
    public List<Cartao> obterTodos() {

        String sql = String.format("SELECT * FROM cartao");
        List<Cartao> cartoes = new ArrayList<Cartao>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Cartao cartao = new Cartao();

                cartao.setId(result.getLong("id"));
                cartao.setNumero(result.getString("numero"));
                cartao.setLimite(result.getLong("limite"));
                cartao.setDiaVencimento(result.getInt("diaVencimento"));
                cartao.setIdconta(result.getLong("idconta"));
                cartao.setIdbandeira(result.getLong("idbandeira"));
                cartoes.add(cartao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartoes;
    }

    @Override
    public boolean insere(Cartao cartao) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO cartao (numero, limite, diaVencimento, idconta, idbandeira) ";
        sql = sql + "VALUES ('%s', %f, %d, %d, %d)";

        sql = String.format(
                sql,
                cartao.getNumero(),
                cartao.getLimite(),
                cartao.getDiaVencimento(),
                cartao.getIdconta(),
                cartao.getIdbandeira());

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean atualiza(Cartao cartao) {

        int linhasModificadas = 0;

        String sql = "UPDATE cartao ";
        sql += "SET numero = '%s', ";
        sql += "limite = %f, ";
        sql += "diaVencimento = %d, ";
        sql += "idconta = %d, ";
        sql += "idbandeira = %d ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                cartao.getNumero(),
                cartao.getLimite(),
                cartao.getDiaVencimento(),
                cartao.getIdconta(),
                cartao.getIdbandeira(),
                cartao.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(Cartao cartao) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM cartao WHERE id = %d";
        sql = String.format(sql, cartao.getId());

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

        String sql = "DELETE FROM cartao WHERE id >= 0";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }
}
