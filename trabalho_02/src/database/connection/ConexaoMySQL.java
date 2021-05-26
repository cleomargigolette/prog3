package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	private Connection conexao;
	private String usuario;
	private String senha;
	
	public ConexaoMySQL() {

		usuario = "root";
		senha = "root";
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco_financeiro?user=" + usuario + "&password=" + senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}
	
}
