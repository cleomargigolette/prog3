package database.DAO;

import database.connection.ConexaoMySQL;
import database.entities.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO implements DAO<PessoaFisica> {

    private Connection connection;

    public PessoaFisicaDAO() {
        connection = new ConexaoMySQL().getConexao();
    }

    @Override
    public PessoaFisica obter(long id) {

        String sql = String.format("SELECT * FROM pessoafisica WHERE id = %d", id);
        PessoaFisica pessoa = null;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                pessoa = new PessoaFisica();

                pessoa.setId(result.getLong("id"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setEmail(result.getString("email"));
                pessoa.setSexo(result.getString("sexo"));
                pessoa.setTelefone(result.getString("telefone"));
                pessoa.setNascimento(LocalDate.parse(result.getString("nascimento")));
                pessoa.setCpf(result.getString("cpf"));
                pessoa.setEndereco(result.getString("endereco"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;

    }

    @Override
    public List<PessoaFisica> obterTodos() {

        String sql = String.format("SELECT * FROM pessoafisica");
        List<PessoaFisica> pessoas = new ArrayList<PessoaFisica>();

        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                PessoaFisica pessoa = new PessoaFisica();

                pessoa.setId(result.getLong("id"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setEmail(result.getString("email"));
                pessoa.setSexo(result.getString("sexo"));
                pessoa.setTelefone(result.getString("telefone"));
                pessoa.setNascimento(LocalDate.parse(result.getString("nascimento")));
                pessoa.setCpf(result.getString("cpf"));
                pessoa.setEndereco(result.getString("endereco"));
                pessoas.add(pessoa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    @Override
    public boolean insere(PessoaFisica pessoa) {

        int linhasModificadas = 0;

        String sql = "INSERT INTO pessoafisica (nome, email, telefone, endereco, sexo, nascimento, cpf) ";
        sql = sql + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')";

        sql = String.format(
                sql,
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getTelefone(),
                pessoa.getEndereco(),
                pessoa.getSexo(),
                pessoa.getNascimento().toString(),
                pessoa.getCpf());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;

    }

    @Override
    public boolean atualiza(PessoaFisica pessoa) {

        int linhasModificadas = 0;

        String sql = "UPDATE pessoafisica ";
        sql += "SET nome = '%s', ";
        sql += "email = '%s', ";
        sql += "telefone = '%s', ";
        sql += "endereco = '%s', ";
        sql += "sexo = '%s', ";
        sql += "nascimento = '%s', ";
        sql += "cpf = '%s' ";
        sql += "WHERE id = %d";

        sql = String.format(
                sql,
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getTelefone(),
                pessoa.getEndereco(),
                pessoa.getSexo(),
                pessoa.getNascimento().toString(),
                pessoa.getCpf(),
                pessoa.getId());
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            linhasModificadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linhasModificadas > 0;

    }

    @Override
    public boolean deleta(PessoaFisica pessoa) {

        int linhasModificadas = 0;

        String sql = "DELETE FROM pessoafisica WHERE id = %d";
        sql = String.format(sql, pessoa.getId());

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
