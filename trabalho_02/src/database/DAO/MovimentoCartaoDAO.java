package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Cartao;
import database.entities.MovimentoCartao;
import database.entities.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MovimentoCartaoDAO implements DAO<MovimentoCartao>{

    private Connection connection;

    public MovimentoCartaoDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public MovimentoCartao obter(long id) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = String.format("SELECT * FROM movimento_cartao WHERE id = %d", id);
        MovimentoCartao movimentoCartao = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                movimentoCartao = new MovimentoCartao();

                movimentoCartao.setId(result.getLong("id"));
                movimentoCartao.setData(LocalDateTime.parse(result.getString("data"), format));
                movimentoCartao.setValor(result.getDouble("valor"));
                movimentoCartao.setIdfatura(result.getLong("idfatura"));
                movimentoCartao.setIdcartao(result.getLong("idcartao"));
                movimentoCartao.setIdestabelecimento(result.getLong("idestabelecimento"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movimentoCartao;

    }

    @Override
    public List<MovimentoCartao> obterTodos() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = String.format("SELECT * FROM movimento_cartao");
        List<MovimentoCartao> movimentosCartao = new ArrayList<MovimentoCartao>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                MovimentoCartao movimentoCartao = new MovimentoCartao();

                movimentoCartao.setId(result.getLong("id"));
                movimentoCartao.setData(LocalDateTime.parse(result.getString("data"), format));
                movimentoCartao.setValor(result.getDouble("valor"));
                movimentoCartao.setId(result.getLong("idfatura"));
                movimentoCartao.setIdcartao(result.getLong("idcartao"));
                movimentoCartao.setIdestabelecimento(result.getLong("idestabelecimento"));

                movimentosCartao.add(movimentoCartao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movimentosCartao;
    }

    @Override
    public boolean insere(MovimentoCartao movimentoCartao) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO movimento_cartao (data, valor, idfatura, idcartao, idestabelecimento) ";
        sql = sql + "VALUES ('%s', %f, %d, %d, %d)";

        sql = String.format(
                sql,
                movimentoCartao.getData(),
                movimentoCartao.getValor(),
                movimentoCartao.getIdfatura(),
                movimentoCartao.getIdcartao(),
                movimentoCartao.getIdestabelecimento());

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean atualiza(MovimentoCartao movimentoCartao) {

        int linhasModificadas = 0;

        String sql = "UPDATE movimento_cartao ";
        sql += "SET data = '%s', ";
        sql += "valor = %f, ";
        sql += "idfatura = %d, ";
        sql += "idcartao = %d, ";
        sql += "idestabelecimento = %d ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                movimentoCartao.getData(),
                movimentoCartao.getValor(),
                movimentoCartao.getIdfatura(),
                movimentoCartao.getIdcartao(),
                movimentoCartao.getIdestabelecimento(),
                movimentoCartao.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(MovimentoCartao movimentoCartao) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM movimento_cartao WHERE id = %d";
        sql = String.format(sql, movimentoCartao.getId());

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

        String sql = "DELETE FROM movimento_cartao WHERE id >= 0";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }
}
