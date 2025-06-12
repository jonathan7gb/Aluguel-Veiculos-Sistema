package appAluguel;

import java.sql.Connection;
import java.sql.ResultSet;

import conexaoBanco.Conexao;
import conexaoBanco.*;
import java.sql.*;
import java.util.*;

public class Carro {

    public static void menu_busca_carro(){
        System.out.println("\n==== Visualizar Carros ====");
        System.out.println("1 - Disponíveis");
        System.out.println("2 - Alugados");
        System.out.println("3 - Em Manutenção");
        System.out.println("4 - Buscar pela Placa");
        System.out.println("5 - Buscar pelo Modelo");
        System.out.println("6 - Buscar pela Marca");
        System.out.println("7 - Voltar ao Menu de Busca");
    }

    public static void todos_carros_disponiveis(){
            try (Connection conn = Conexao.getConexao()) {
                boolean encontrado = false;

                            String sql ="SELECT * FROM aluguel_veiculos.View_todos_carros_disponiveis";
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
     public static void todos_carros_alugados(){
            try (Connection conn = Conexao.getConexao()) {
                boolean encontrado = false;

                            String sql ="SELECT * FROM aluguel_veiculos.View_todos_carros_alugados";
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
     public static void todos_carros_manutencao(){
            try (Connection conn = Conexao.getConexao()) {
                boolean encontrado = false;

                            String sql ="SELECT * FROM aluguel_veiculos.View_todos_carros_manutenção";
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
