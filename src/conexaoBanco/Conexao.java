package conexaoBanco;
import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/aluguel_veiculos";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }
}