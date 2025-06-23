package views;
import conexaoBanco.Conexao;
import java.sql.*;
import java.util.*;

public class CarrosViews {

    public static void menu_busca_carro(){
    	try {
	    	System.out.println("\n╔═════════════════════════════════════╗");
	        System.out.println("║          VISUALIZAR CARROS          ║");
	        System.out.println("╚═════════════════════════════════════╝");
	        Thread.sleep(250);
	        System.out.println("1 - Disponíveis");
	        Thread.sleep(250);
	        System.out.println("2 - Alugados");
	        Thread.sleep(250);
	        System.out.println("3 - Em Manutenção");
	        Thread.sleep(250);
	        System.out.println("4 - Buscar pela Placa");
	        Thread.sleep(250);
	        System.out.println("5 - Buscar pelo Modelo");
	        Thread.sleep(250);
	        System.out.println("6 - Buscar pela Marca");
	        Thread.sleep(250);
	        System.out.println("7 - Listar Todos Carros");
            Thread.sleep(250);
	        System.out.println("8 - Voltar ao Menu de Busca");
	        System.out.println("══════════════════════════════════════");
    	} catch (Exception e) {
        }
    }

    public static void todos_carros_disponiveis(){
            try (Connection conn = Conexao.getConexao()) {
                boolean encontrado = false;

                String sql ="SELECT * FROM aluguel_veiculos.View_todos_carros_disponiveis";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("");
                
                System.out.println("╔═════════════════════════════════════╗");
    	        System.out.println("║     TODOS OS CARROS DISPONÍVEIS     ║");
    	        System.out.println("╚═════════════════════════════════════╝");
                System.out.print("╔══════════════════════════════════════");
                while (rs.next()) {
                    encontrado = true;
                    System.out.printf("\n║   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                    System.out.println("║   Tipo: " + rs.getString("tipo_veiculo") );
                    System.out.println("║   Ano de Fabricação: " + rs.getInt("ano_fabricacao_veiculo"));
                    System.out.println("║   Status: " + rs.getString("status_veiculo"));
                    System.out.print("╠══════════════════════════════════════");
                    Thread.sleep(350);            
                }
                if(encontrado == true) {
                    System.out.println("\n");
                }
                if(encontrado != true) {
                	System.out.println("╗");
                    System.out.println("        NENHUM CARRO ENCONTRADO       ");
                    System.out.println("╚══════════════════════════════════════╝\n");
                }
        
            }catch (Exception e) {
		        e.printStackTrace();
		    }
        }

//----------------------------------------------------------------------------------------

     public static void todos_carros_alugados(){
            try (Connection conn = Conexao.getConexao()) {
                boolean encontrado = false;

                String sql ="SELECT * FROM aluguel_veiculos.View_todos_carros_alugados";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("");
                
                System.out.println("╔═════════════════════════════════════╗");
    	        System.out.println("║      TODOS OS CARROS ALUGADOS       ║");
    	        System.out.println("╚═════════════════════════════════════╝");
                System.out.print("╔══════════════════════════════════════");
                while (rs.next()) {
                    encontrado = true;
                    System.out.printf("\n║   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                    System.out.println("║   Tipo: " + rs.getString("tipo_veiculo") );
                    System.out.println("║   Ano de Fabricação: " + rs.getInt("ano_fabricacao_veiculo"));
                    System.out.println("║   Status: " + rs.getString("status_veiculo"));
                    System.out.print("╠══════════════════════════════════════");
                    Thread.sleep(350);            
                }
                if(encontrado == true) {
                    System.out.println("\n");
                }
                if(encontrado != true) {
                	System.out.println("╗");
                    System.out.println("        NENHUM CARRO ENCONTRADO       ");
                    System.out.println("╚══════════════════════════════════════╝\n");
                }
                            
                            	
        
            }catch (Exception e) {
		        e.printStackTrace();
		    }
        }
        
//----------------------------------------------------------------------------------------        

        public static void todos_carros_manutencao(){
            try (Connection conn = Conexao.getConexao()) {
                boolean encontrado = false;

                String sql ="SELECT * FROM aluguel_veiculos.View_todos_carros_manutenção";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("");
                 
                System.out.println("╔═════════════════════════════════════╗");
    	        System.out.println("║    TODOS OS CARROS EM MANUTENÇÃO    ║");
    	        System.out.println("╚═════════════════════════════════════╝");
                System.out.print("╔══════════════════════════════════════");
                while (rs.next()) {
                    encontrado = true;
                    System.out.printf("\n║   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                    System.out.println("║   Tipo: " + rs.getString("tipo_veiculo") );
                    System.out.println("║   Ano de Fabricação: " + rs.getInt("ano_fabricacao_veiculo"));
                    System.out.println("║   Status: " + rs.getString("status_veiculo"));
                    System.out.print("╠══════════════════════════════════════");
                    Thread.sleep(350);            
                }
                if(encontrado == true) {
                    System.out.println("\n");
                }
                if(encontrado != true) {
                	System.out.println("╗");
                    System.out.println("         NENHUM CARRO ENCONTRADO       ");
                    System.out.println("╚══════════════════════════════════════╝\n");
                }
        
            }catch (Exception e) {
		        e.printStackTrace();
		    }
        }

//----------------------------------------------------------------------------------------

	    public static void buscar_carro_pela_placa(){
	        try (Connection conn = Conexao.getConexao()) {
	            boolean encontrado = false;
	
	            Scanner leia = new Scanner(System.in);
	
	            Thread.sleep(500);
	            System.out.println("\n╔══════════════════════════════════════════╗");
	            System.out.println("             BUSCAR PELA PLACA              ");
	            System.out.println("╚══════════════════════════════════════════╝");
	            System.out.print("? - Insira a placa do carro: ");
	            String placa_ler = leia.nextLine();
	
	            String sql ="SELECT * FROM veiculos where placa_veiculo = ? and tipo_veiculo = 'Carro'";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, placa_ler);
	            ResultSet rs = pstmt.executeQuery();
	
	            System.out.println("");
	            
	            System.out.print("╔══════════════════════════════════════");
                while (rs.next()) {
                    encontrado = true;
                    System.out.printf("\n║   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                    System.out.println("║   Tipo: " + rs.getString("tipo_veiculo") );
                    System.out.println("║   Ano de Fabricação: " + rs.getInt("ano_fabricacao_veiculo"));
                    System.out.println("║   Status: " + rs.getString("status_veiculo"));
                    System.out.print("╠══════════════════════════════════════");
                    Thread.sleep(350);            
                }
                if(encontrado == true) {
                    System.out.println("\n");
                }
                if(encontrado != true) {
                	System.out.println("╗");
                    System.out.println("         NENHUM CARRO ENCONTRADO       ");
                    System.out.println("╚══════════════════════════════════════╝\n");
                }
	        }catch (InputMismatchException e) {
	            System.out.println("🚫 Entrada inválida!");
	       }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
    
//----------------------------------------------------------------------------------------

	    public static void buscar_carro_pelo_modelo(){
	        try (Connection conn = Conexao.getConexao()) {
	            boolean encontrado = false;
	
	            Scanner leia = new Scanner(System.in);
	
	            Thread.sleep(500);
	            System.out.println("\n╔══════════════════════════════════════════╗");
	            System.out.println("             BUSCAR PELO MODELO             ");
	            System.out.println("╚══════════════════════════════════════════╝");
	            System.out.print("? - Insira o modelo do carro: ");
	            String modelo_ler = leia.nextLine();
	
	            String sql ="SELECT * FROM veiculos WHERE modelo_veiculo LIKE ? and tipo_veiculo = 'Carro'";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, "%" + modelo_ler + "%");
	            ResultSet rs = pstmt.executeQuery();
	
	            System.out.println("");
	            
	            System.out.print("╔══════════════════════════════════════");
                while (rs.next()) {
                    encontrado = true;
                    System.out.printf("\n║   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                    System.out.println("║   Tipo: " + rs.getString("tipo_veiculo") );
                    System.out.println("║   Ano de Fabricação: " + rs.getInt("ano_fabricacao_veiculo"));
                    System.out.println("║   Status: " + rs.getString("status_veiculo"));
                    System.out.print("╠══════════════════════════════════════");
                    Thread.sleep(350);            
                }
                if(encontrado == true) {
                    System.out.println("\n");
                }
                if(encontrado != true) {
                	System.out.println("╗");
                    System.out.println("         NENHUM CARRO ENCONTRADO       ");
                    System.out.println("╚═══════════════════════════════════════════╝\n");
                }
	        }catch (InputMismatchException e) {
	            System.out.println("🚫 Entrada inválida!");
	       }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

//----------------------------------------------------------------------------------------

	    public static void buscar_carro_pela_marca(){
	        try (Connection conn = Conexao.getConexao()) {
	            boolean encontrado = false;
	
	            Scanner leia = new Scanner(System.in);
	
	            Thread.sleep(500);
	            System.out.println("\n╔══════════════════════════════════════════╗");
	            System.out.println("              BUSCAR PELA MARCA             ");
	            System.out.println("╚══════════════════════════════════════════╝");
	            System.out.print("? - Insira a marca do carro: ");
	            String marca_ler = leia.nextLine();
	
	            String sql ="SELECT * FROM veiculos WHERE marca_veiculo LIKE ? and tipo_veiculo = 'Carro'";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, "%" + marca_ler + "%");
	            ResultSet rs = pstmt.executeQuery();
	
	            System.out.println("");
	            
	            System.out.print("╔══════════════════════════════════════");
                while (rs.next()) {
                    encontrado = true;
                    System.out.printf("\n║   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
                    System.out.println("║   Tipo: " + rs.getString("tipo_veiculo") );
                    System.out.println("║   Ano de Fabricação: " + rs.getInt("ano_fabricacao_veiculo"));
                    System.out.println("║   Status: " + rs.getString("status_veiculo"));
                    System.out.print("╠══════════════════════════════════════");
                    Thread.sleep(350);            
                }
                if(encontrado == true) {
                    System.out.println("\n");
                }
                if(encontrado != true) {
                	System.out.println("╗");
                    System.out.println("         NENHUM CARRO ENCONTRADO       ");
                    System.out.println("╚══════════════════════════════════════╝\n");
                }
	        }catch (InputMismatchException e) {
	            System.out.println("🚫 Entrada inválida!");
	       }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	    
	    
//----------------------------------------------------------------------------------------
	    
	    
	    public static void listar_todos_carros(){
	        try (Connection conn = Conexao.getConexao()) {
	            boolean encontrado = false;

	            String sql ="SELECT * FROM veiculos WHERE tipo_veiculo = 'Carro'";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            System.out.println("");
	                        
	            System.out.println("╔═════════════════════════════════════╗");
		        System.out.println("║       LISTAR TODOS OS CARROS        ║");
		        System.out.println("╚═════════════════════════════════════╝");
	            System.out.print("╔══════════════════════════════════════");
	            while (rs.next()) {
	                encontrado = true;
	                System.out.printf("\n║   [%s] %s %s                              %n", rs.getString("placa_veiculo"), rs.getString("marca_veiculo"), rs.getString("modelo_veiculo"));
	                System.out.println("║   Tipo: " + rs.getString("tipo_veiculo") );
	                System.out.println("║   Ano de Fabricação: " + rs.getInt("ano_fabricacao_veiculo"));
	                System.out.println("║   Status: " + rs.getString("status_veiculo"));
	                System.out.print("╠══════════════════════════════════════");
	                Thread.sleep(350);            
	            }
	            if(encontrado == true) {
	                System.out.println("\n");
	            }
	            if(encontrado != true) {
	            	System.out.println("╗");
	                System.out.println("        NENHUM CARRO ENCONTRADO       ");
	                System.out.println("╚══════════════════════════════════════╝\n");
	            }
	    
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
}
