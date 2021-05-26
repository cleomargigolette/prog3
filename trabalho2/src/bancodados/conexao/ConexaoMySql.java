package bancodados.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {

    private Connection conexao;
    private String usuario;
    private String senha;

    public ConexaoMySql (){
        usuario = "prog3";
        senha = "prog3";

        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco_finaceiro?user=" + usuario + "&password=" + senha);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}
