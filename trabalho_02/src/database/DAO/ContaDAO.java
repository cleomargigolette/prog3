package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO implements DAO<Conta> {

    private Connection connection;

    public ContaDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public Conta obter(long id) {

        String sql = String.format("SELECT * FROM conta WHERE id = %d", id);
        Conta conta = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                conta = new Conta();

                conta.setId(result.getLong("id"));
                conta.setNumero(result.getString("numero"));
                conta.setLimite(result.getDouble("limite"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setIdagencia(result.getLong("idagencia"));
                conta.setIdgerente(result.getLong("idgerente"));
                conta.setIdPessoaFisica(result.getLong("idpessoafisica"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conta;
    }

    @Override
    public List<Conta> obterTodos() {

        String sql = String.format("SELECT * FROM conta");
        List<Conta> contas = new ArrayList<Conta>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Conta conta = new Conta();

                conta.setId(result.getLong("id"));
                conta.setNumero(result.getString("numero"));
                conta.setLimite(result.getDouble("limite"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setIdagencia(result.getLong("idagencia"));
                conta.setIdgerente(result.getLong("idgerente"));
                conta.setIdPessoaFisica(result.getLong("idpessoafisica"));
                contas.add(conta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contas;
    }

    @Override
    public boolean insere(Conta conta) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO conta (numero, saldo, limite, idpessoafisica, idagencia, idgerente) ";
        sql = sql + "VALUES ('%s', %f, %f, %d, %d, %d)";

        sql = String.format(
                sql,
                conta.getNumero(),
                conta.getSaldo(),
                conta.getLimite(),
                conta.getIdPessoaFisica(),
                conta.getIdagencia(),
                conta.getIdgerente());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;

    }

    @Override
    public boolean atualiza(Conta conta) {

        int linhasModificadas = 0;

        String sql = "UPDATE conta ";
        sql += "SET numero = '%s', ";
        sql += "saldo = '%s', ";
        sql += "limite = '%s', ";
        sql += "idPessoaFisica = '%s', ";
        sql += "idagencia = '%s', ";
        sql += "idgerente = '%s' ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                conta.getNumero(),
                conta.getSaldo(),
                conta.getLimite(),
                conta.getIdPessoaFisica(),
                conta.getIdagencia(),
                conta.getIdgerente());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(Conta conta) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM conta WHERE id = %d";
        sql = String.format(sql, conta.getId());

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
