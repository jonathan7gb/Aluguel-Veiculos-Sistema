package views;
import conexaoBanco.*;
import java.sql.*;
import java.util.*;

public class VansViews {

    public static  void menu_busca_van(){
    	try {
	    	System.out.println("\n╔═════════════════════════════════════╗");
	        System.out.println("║          VISUALIZAR VANS            ║");
	        System.out.println("╚═════════════════════════════════════╝");
	        Thread.sleep(250);
	        System.out.println("1 - Disponíveis");
	        Thread.sleep(250);
	        System.out.println("2 - Alugadas");
	        Thread.sleep(250);
	        System.out.println("3 - Em Manutenção");
	        Thread.sleep(250);
	        System.out.println("4 - Buscar pela Placa");
	        Thread.sleep(250);
	        System.out.println("5 - Buscar pelo Modelo");
	        Thread.sleep(250);
	        System.out.println("6 - Buscar pela Marca");
	        Thread.sleep(250);
	        System.out.println("7 - Listar Todas Vans");
            Thread.sleep(250);
	        System.out.println("0 - Voltar ao Menu de Busca");
	        System.out.println("══════════════════════════════════════");
    	} catch (Exception e) {
        }
    }
    
    
//--------------------------------------------------------------------

    
    public static void todas_vans_disponiveis(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

            String sql ="SELECT * FROM aluguel_veiculos.View_todas_vans_disponiveis";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("");
            
            System.out.println("╔═════════════════════════════════════╗");
	        System.out.println("║      TODAS AS VANS DISPONÍVEIS      ║");
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
                System.out.println("            NENHUMA VAN ENCONTRADA       ");
                System.out.println("╚══════════════════════════════════════╝\n");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    
//----------------------------------------------------------------------------------------

    
	 public static void todas_vans_alugados(){
	        try (Connection conn = Conexao.getConexao()) {
	            boolean encontrado = false;
	
	            String sql ="SELECT * FROM aluguel_veiculos.View_todas_vans_alugadas";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	
	            System.out.println("");
	
	            System.out.println("╔═════════════════════════════════════╗");
		        System.out.println("║       TODAS AS VANS ALUGADAS        ║");
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
	                System.out.println("            NENHUMA VAN ENCONTRADA       ");
	                System.out.println("╚══════════════════════════════════════╝\n");
	            }  
	    
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	 
//----------------------------------------------------------------------------------------    
	
	 
	 public static void todas_vans_manutencao(){
	        try (Connection conn = Conexao.getConexao()) {
	            boolean encontrado = false;
	
	            String sql ="SELECT * FROM aluguel_veiculos.View_todas_vans_manutenção";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	
	            System.out.println("");
	            
	            System.out.println("╔═════════════════════════════════════╗");
		        System.out.println("║     TODAS AS VANS EM MANUTENÇÃO     ║");
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
	                System.out.println("            NENHUMA VAN ENCONTRADA       ");
	                System.out.println("╚══════════════════════════════════════╝\n");
	            }
	    
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	 
//----------------------------------------------------------------------------------------
	
	 
	public static void buscar_vans_pela_placa(){
	    try (Connection conn = Conexao.getConexao()) {
	        boolean encontrado = false;
	
	        Scanner leia = new Scanner(System.in);
	
	        Thread.sleep(500);
	        System.out.println("\n╔══════════════════════════════════════════╗");
	        System.out.println("             BUSCAR PELA PLACA              ");
	        System.out.println("╚══════════════════════════════════════════╝");
	        System.out.print("? - Insira a placa da van: ");
	        String placa_ler = leia.nextLine();
	
	        String sql ="SELECT * FROM veiculos where placa_veiculo = ? and tipo_veiculo = 'Van'";
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
	            System.out.println("            NENHUMA VAN ENCONTRADA       ");
	            System.out.println("╚══════════════════════════════════════╝\n");
	        }
	        
	    }catch (InputMismatchException e) {
	        System.out.println("🚫 Entrada inválida!");
	   }catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
//----------------------------------------------------------------------------------------
	
	
	public static void buscar_vans_pelo_modelo(){
	    try (Connection conn = Conexao.getConexao()) {
	        boolean encontrado = false;
	
	        Scanner leia = new Scanner(System.in);
	
	        Thread.sleep(500);
	        System.out.println("\n╔══════════════════════════════════════════╗");
	        System.out.println("             BUSCAR PELO MODELO             ");
	        System.out.println("╚══════════════════════════════════════════╝");
	        System.out.print("? - Insira o modelo da van: ");
	        String modelo_ler = leia.nextLine();
	
	        String sql ="SELECT * FROM veiculos WHERE modelo_veiculo LIKE ? and tipo_veiculo = 'Van'";
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
	            System.out.println("            NENHUMA VAN ENCONTRADA       ");
	            System.out.println("╚══════════════════════════════════════╝\n");
	        }
	        
	    }catch (InputMismatchException e) {
	        System.out.println("🚫 Entrada inválida!");
	   }catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
//----------------------------------------------------------------------------------------
	
	
	public static void buscar_vans_pela_marca(){
	    try (Connection conn = Conexao.getConexao()) {
	        boolean encontrado = false;
	
	        Scanner leia = new Scanner(System.in);
	
	        Thread.sleep(500);
	        System.out.println("\n╔══════════════════════════════════════════╗");
	        System.out.println("              BUSCAR PELA MARCA             ");
	        System.out.println("╚══════════════════════════════════════════╝");
	        System.out.print("? - Insira a marca da van: ");
	        String marca_ler = leia.nextLine();
	
	        String sql ="SELECT * FROM veiculos WHERE marca_veiculo LIKE ? and tipo_veiculo = 'Van'";
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
	            System.out.println("            NENHUMA VAN ENCONTRADA       ");
	            System.out.println("╚══════════════════════════════════════╝\n");
	        }
	        
	    }catch (InputMismatchException e) {
	        System.out.println("🚫 Entrada inválida!");
	   }catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
//----------------------------------------------------------------------------------------
    
    
    public static void listar_todas_vans(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

            String sql ="SELECT * FROM veiculos WHERE tipo_veiculo = 'Vans'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("");
                        
            System.out.println("╔═════════════════════════════════════╗");
	        System.out.println("║        LISTAR TODAS AS VANS         ║");
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
                System.out.println("         NENHUMA VAN ENCONTRADA       ");
                System.out.println("╚══════════════════════════════════════╝\n");
            }
    
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
