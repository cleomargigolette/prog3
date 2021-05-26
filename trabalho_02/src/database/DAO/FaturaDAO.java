package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Estabelecimento;
import database.entities.Fatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO implements DAO<Fatura> {

    private Connection connection;

    public FaturaDAO() {
        connection = new ConexaoMySQL().getConexao();
    }


    @Override
    public Fatura obter(long id) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = String.format("SELECT * FROM fatura WHERE id = %d", id);
        Fatura fatura = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                fatura = new Fatura();

                fatura.setId(result.getLong("id"));
                fatura.setVencimento(LocalDateTime.parse(result.getString("vencimento"), format));
                fatura.setValor(result.getDouble("valor"));
                fatura.setValorminimo(result.getDouble("valorminimo"));
                fatura.setDatapagamento(result.getString("datapagamento") != null ? LocalDateTime.parse(result.getString("datapagamento"), format) : null );
                fatura.setValorpago(result.getDouble("valorpago"));
                fatura.setIdcartao(result.getLong("idcartao"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fatura;
    }

    @Override
    public List<Fatura> obterTodos() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = String.format("SELECT * FROM fatura");
        List<Fatura> faturas = new ArrayList<Fatura>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Fatura fatura = new Fatura();

                fatura.setId(result.getLong("id"));
                fatura.setVencimento(LocalDateTime.parse(result.getString("vencimento"), format));
                fatura.setValor(result.getDouble("valor"));
                fatura.setValorminimo(result.getDouble("valorminimo"));
                fatura.setDatapagamento(result.getString("datapagamento") != null ? LocalDateTime.parse(result.getString("datapagamento"), format) : null );
                fatura.setValorpago(result.getDouble("valorpago"));
                fatura.setIdcartao(result.getLong("idcartao"));
                faturas.add(fatura);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return faturas;
    }

    @Override
    public boolean insere(Fatura fatura) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO fatura (vencimento, valor, valorminimo, datapagamento, valorpago,  idcartao) ";
        sql = sql + "VALUES ('%s', %f, %f, '%s', %f, %d)";

        sql = String.format(
                sql,
                fatura.getVencimento().toString(),
                fatura.getValor(),
                fatura.getValorminimo(),
                fatura.getDatapagamento().toString(),
                fatura.getValorpago(),
                fatura.getIdcartao());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean atualiza(Fatura fatura) {

        int linhasModificadas = 0;

        String sql = "UPDATE fatura ";
        sql += "SET vencimento = '%s', ";
        sql += "valor = %f, ";
        sql += "valorminimo = %f, ";
        sql += "datapagamento = '%s', ";
        sql += "valorpago = %f, ";
        sql += "idcartao = %d ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                fatura.getVencimento(),
                fatura.getValor(),
                fatura.getValorminimo(),
                fatura.getDatapagamento(),
                fatura.getValorpago(),
                fatura.getIdcartao(),
                fatura.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(Fatura fatura) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM fatura WHERE id = %d";
        sql = String.format(sql, fatura.getId());

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
