package appAluguel;
import conexaoBanco.*;
import java.sql.*;
import java.util.*;

public class VeiculosViews {

    public static void todos_veiculos_disponiveis(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

                        String sql ="SELECT * FROM aluguel_veiculos.view_todos_veiculos_disponiveis";
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

    public static void todos_veiculos_alugados(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

            String sql ="SELECT * FROM aluguel_veiculos.View_todos_veiculos_alugados";
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

    public static void View_todos_veiculos_manutenção(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

            String sql ="SELECT * FROM aluguel_veiculos.View_todos_veiculos_manutenção";
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
