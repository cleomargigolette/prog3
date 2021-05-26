package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.Gerente;
import database.entities.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenteDAO implements DAO<Gerente>{

    private Connection connection;

    public GerenteDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public Gerente obter(long id) {

        String sql = String.format("SELECT * FROM gerente WHERE id = %d", id);
        Gerente gerente = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                gerente = new Gerente();

                gerente.setId(result.getLong("id"));
                gerente.setMatricula(result.getString("matricula"));
                gerente.setNome(result.getString("nome"));
                gerente.setCpf(result.getString("cpf"));
                gerente.setSexo(result.getString("sexo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gerente;
    }

    @Override
    public List<Gerente> obterTodos() {

        String sql = String.format("SELECT * FROM gerente");
        List<Gerente> gerentes = new ArrayList<Gerente>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Gerente gerente = new Gerente();

                gerente.setId(result.getLong("id"));
                gerente.setMatricula(result.getString("matricula"));
                gerente.setNome(result.getString("nome"));
                gerente.setCpf(result.getString("cpf"));
                gerente.setSexo(result.getString("sexo"));
                gerentes.add(gerente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gerentes;
    }

    @Override
    public boolean insere(Gerente gerente) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO gerente (matricula, nome, cpf, sexo) ";
        sql = sql + "VALUES ('%s', '%s', '%s', '%s')";

        sql = String.format(
                sql,
                gerente.getMatricula(),
                gerente.getNome(),
                gerente.getCpf(),
                gerente.getSexo());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean atualiza(Gerente gerente) {

        int linhasModificadas = 0;

        String sql = "UPDATE gerente ";
        sql += "SET matricula = '%s', ";
        sql += "nome = '%s', ";
        sql += "cpf = '%s', ";
        sql += "sexo = '%s' ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                gerente.getMatricula(),
                gerente.getNome(),
                gerente.getCpf(),
                gerente.getSexo(),
                gerente.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }

    @Override
    public boolean deleta(Gerente gerente) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM gerente WHERE id = %d";
        sql = String.format(sql, gerente.getId());

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

        String sql = "DELETE FROM gerente WHERE id >= 0";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;
    }
}
