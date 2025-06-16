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

//----------------------------------------------------------------------------------------

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

//----------------------------------------------------------------------------------------

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

//----------------------------------------------------------------------------------------

    public static void buscar_veiculo_placa(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

            Scanner leia = new Scanner(System.in);

            Thread.sleep(500);
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("             BUSCAR PELA PLACA              ");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("? - Insira a placa do veículo: ");
            String placa_ler = leia.nextLine();

            String sql ="SELECT * FROM veiculos where placa_veiculo = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, placa_ler);
            ResultSet rs = pstmt.executeQuery(sql);

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
    
//----------------------------------------------------------------------------------------

    public static void buscar_veiculo_modelo(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

            Scanner leia = new Scanner(System.in);

            Thread.sleep(500);
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("             BUSCAR PELO MODELO             ");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("? - Insira o modelo do veículo: ");
            String modelo_ler = leia.nextLine();

            String sql ="SELECT * FROM veiculos where modelo_veiculo = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, modelo_ler);
            ResultSet rs = pstmt.executeQuery(sql);

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

//----------------------------------------------------------------------------------------

    public static void buscar_veiculo_marca(){
        try (Connection conn = Conexao.getConexao()) {
            boolean encontrado = false;

            Scanner leia = new Scanner(System.in);

            Thread.sleep(500);
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("              BUSCAR PELA MARCA             ");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("? - Insira a marca do veículo: ");
            String marca_ler = leia.nextLine();

            String sql ="SELECT * FROM veiculos where marca_veiculo = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, marca_ler);
            ResultSet rs = pstmt.executeQuery(sql);

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

//----------------------------------------------------------------------------------------

public static void View_todos_veiculos_apagados(){
    try (Connection conn = Conexao.getConexao()) {
        boolean encontrado = false;

        Thread.sleep(500);
        String sql ="SELECT * FROM aluguel_veiculos.View_todos_veiculos_inativos";
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
