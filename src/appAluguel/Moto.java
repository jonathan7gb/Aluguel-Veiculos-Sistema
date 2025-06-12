package appAluguel;
import conexaoBanco.*;
import java.sql.*;
import java.util.*;

public class Moto {

    public static  void menu_busca_moto(){
        System.out.println("\n==== Visualizar Motos ====");
        System.out.println("1 - Disponíveis");
        System.out.println("2 - Alugadas");
        System.out.println("3 - Em Manutenção");
        System.out.println("4 - Buscar pela Placa");
        System.out.println("5 - Buscar pelo Modelo");
        System.out.println("6 - Buscar pela Marca");
        System.out.println("7 - Voltar ao Menu de Busca");
    }

    public static void todas_motos_disponiveis(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

                        String sql ="SELECT * FROM aluguel_veiculos.View_todos_motos_disponiveis";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);

                        System.out.println("");
                        
                        while (rs.next()) {
                            encontrado = true;
                            System.out.println("╔══════════════════════════════════════════╗");
                            System.out.printf("   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                            System.out.println("   Tipo: " + rs.getString("tipo_veiculo") );
                            System.out.println("   Ano de Fabricação: " + rs.getString("ano_fabricacao_veiculo"));
                            System.out.println("╚══════════════════════════════════════════╝");
                            Thread.sleep(350);            
                        }
                        if(encontrado == true) {
                            System.out.println("");
                        }
                        if(encontrado != true) {
                            System.out.println("╔═════════════════════════════════════╗");
                            System.out.println("║      NENHUM VEÍCULO ENCONTRADO      ║");
                            System.out.println("╚═════════════════════════════════════╝\n");
                        }
    
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
 public static void todas_motos_alugados(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

                        String sql ="SELECT * FROM aluguel_veiculos.View_todos_motos_alugados";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);

                        System.out.println("");
                        
                        while (rs.next()) {
                            encontrado = true;
                            System.out.println("╔══════════════════════════════════════════╗");
                            System.out.printf("   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                            System.out.println("   Tipo: " + rs.getString("tipo_veiculo") );
                            System.out.println("   Ano de Fabricação: " + rs.getString("ano_fabricacao_veiculo"));
                            System.out.println("╚══════════════════════════════════════════╝");
                            Thread.sleep(350);            
                        }
                        if(encontrado == true) {
                            System.out.println("");
                        }
                        if(encontrado != true) {
                            System.out.println("╔═════════════════════════════════════╗");
                            System.out.println("║      NENHUM VEÍCULO ENCONTRADO      ║");
                            System.out.println("╚═════════════════════════════════════╝\n");
                        }
    
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
 public static void todas_motos_manutencao(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

                        String sql ="SELECT * FROM aluguel_veiculos.View_todos_motos_manutenção";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);

                        System.out.println("");
                        
                        while (rs.next()) {
                            encontrado = true;
                            System.out.println("╔══════════════════════════════════════════╗");
                            System.out.printf("   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                            System.out.println("   Tipo: " + rs.getString("tipo_veiculo") );
                            System.out.println("   Ano de Fabricação: " + rs.getString("ano_fabricacao_veiculo"));
                            System.out.println("╚══════════════════════════════════════════╝");
                            Thread.sleep(350);            
                        }
                        if(encontrado == true) {
                            System.out.println("");
                        }
                        if(encontrado != true) {
                            System.out.println("╔═════════════════════════════════════╗");
                            System.out.println("║      NENHUM VEÍCULO ENCONTRADO      ║");
                            System.out.println("╚═════════════════════════════════════╝\n");
                        }
    
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
