package appAluguel;
import conexaoBanco.*;
import java.sql.*;
import java.util.*;

public class Veiculo {

    Scanner scStr = new Scanner(System.in);
    Scanner scNum = new Scanner(System.in);

    private String tipoVeiculo;
    private String modeloVeiculo;
    private String marcaVeiculo;
    private String placaVeiculo;
    private int anoFabricacaoVeiculo;
    
    public Veiculo(String tipo, String modelo, String marca, String placa, int ano_fabricacao){
        this.tipoVeiculo = tipo;
        this.modeloVeiculo = modelo;
        this.marcaVeiculo = marca;
        this.placaVeiculo = placa;
        this.anoFabricacaoVeiculo = ano_fabricacao;
    }
    
    public String getTipoVeiculo(){
        return this.tipoVeiculo;
    }
    public String getModeloVeiculo(){
        return this.modeloVeiculo;
    }
    public String getMarcaVeiculo(){
        return this.marcaVeiculo;
    }
    public String getPlacaVeiculo(){
        return this.placaVeiculo;
    }
    public int getAnoFabricacaoVeiculo(){
        return this.anoFabricacaoVeiculo;
    }

    public static void cadastrar_veiculo(Scanner scStr, Scanner scNum) {
    	try (Connection conn = Conexao.getConexao()) {
    		
            String tipo = "";

            System.out.println("\n==== CADASTRAR VEÍCULO ====");
            System.out.print("- Tipo do Veículo\n1 - Carro\n2 - Moto\n3 - Van\nEscolha: ");
            int tipoEscolha = scNum.nextInt();

            switch(tipoEscolha){
                case 1:
                    tipo = "Carro";
                    break;
                case 2:
                    tipo = "Moto";
                    break;
                case 3:
                    tipo = "Van";
                    break;
                default:
                    System.out.println(" -- Escolha inválida -- ");
                    tipo = "Inválido";
                    break;
            }

            if(tipo != "Inválido"){
                System.out.print("- Modelo do Veículo: ");
                String modelo = scStr.nextLine();
                System.out.print("- Marca do Veículo: ");
                String marca = scStr.nextLine();
                try {
	                System.out.print("- Placa do Veículo: ");
	                String placa = scStr.nextLine();
                
                System.out.print("- Ano de Fabricação do Veículo: ");
                int ano_fabricacao = scNum.nextInt();

                if(ano_fabricacao > 2025 || ano_fabricacao < 1901){
                    System.out.println(" -- Ano de Fabricação inválido -- ");
                }else{
                    
                    Veiculo v1 = new Veiculo(tipo, modelo, marca, placa, ano_fabricacao);
                    
                    String tipoCad = v1.getTipoVeiculo();
                    String modeloCad = v1.getModeloVeiculo();
                    String marcaCad = v1.getMarcaVeiculo();
                    String placaCad = v1.getPlacaVeiculo();
                    int anoFabricacaoCad = v1.getAnoFabricacaoVeiculo();

                    String sql = "INSERT INTO veiculos (tipo_veiculo, modelo_veiculo, marca_veiculo, placa_veiculo, ano_fabricacao_veiculo) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, tipoCad);
                    stmt.setString(2, modeloCad);
                    stmt.setString(3, marcaCad);
                    stmt.setString(4, placaCad);
                    stmt.setInt(5, anoFabricacaoCad);
                    stmt.executeUpdate();

                    System.out.println("\n==== VEÍCULO CADASTRADO COM SUCESSO ====\n");
                }
                
               }catch (SQLIntegrityConstraintViolationException e) {
                	System.out.println("❌ Erro: Já existe um veículo com essa placa!\n");
               } catch (SQLException e) {
                   System.out.println("❌ Erro no banco: " + e.getMessage() + "\n");
               }
                
            }
    	}catch (Exception e) {
            e.printStackTrace();
        }
    }
    	
    	
    	public static void buscar_orientacoes(Scanner scStr, Scanner scNum) {
    		try (Connection conn = Conexao.getConexao()) {

    		int escolhaBuscaPrincipal = 0;
    		int escolhaBuscaTodos = 0;

            System.out.println("\n==== Buscar Veículos ====");
            System.out.println("1 - Visualizar Todos");
            System.out.println("2 - Visualizar Carros");
            System.out.println("3 - Visualizar Motos");
            System.out.println("4 - Visualizar Vans");
            System.out.println("5 - Visualizar Todos Apagados");
            System.out.println("6 - Voltar ao Menu Principal");
            System.out.print("? - Sua escolha: ");
            escolhaBuscaPrincipal = scNum.nextInt();

            switch (escolhaBuscaPrincipal) {
                case 1:
                    System.out.println("\n==== Visualizar Todos ====");
                    System.out.println("1 - Disponíveis");
                    System.out.println("2 - Alugados");
                    System.out.println("3 - Em Manutenção");
                    System.out.println("4 - Buscar pela Placa");
                    System.out.println("5 - Buscar pelo Modelo");
                    System.out.println("6 - Buscar pela Marca");
                    System.out.println("7 - Voltar ao Menu de Busca");
                    System.out.print("? - Sua escolha: ");
                    escolhaBuscaTodos = scNum.nextInt();
                    
                    switch(escolhaBuscaTodos) {
                    	case 1:
                    		break;
                    	case 2:
                    		break;
                    	case 3:
                    		break;
                    	case 4:
                    		break;
                    	case 5:
                    		break;
                    	case 6:
                    		break;
                    	case 7:
                            System.out.println("");
                            break;
                        default:
                            System.out.println(" \n-- Escolha Inválida --\n");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n==== Visualizar Carros ====");
                    System.out.println("1 - Disponíveis");
                    System.out.println("2 - Alugados");
                    System.out.println("3 - Em Manutenção");
                    System.out.println("4 - Buscar pela Placa");
                    System.out.println("5 - Buscar pelo Modelo");
                    System.out.println("6 - Buscar pela Marca");
                    System.out.println("7 - Voltar ao Menu de Busca");
                    System.out.print("? - Sua escolha: ");
                    escolhaBuscaTodos = scNum.nextInt();
                    break;

                case 3:
                    System.out.println("\n==== Visualizar Motos ====");
                    System.out.println("1 - Disponíveis");
                    System.out.println("2 - Alugadas");
                    System.out.println("3 - Em Manutenção");
                    System.out.println("4 - Buscar pela Placa");
                    System.out.println("5 - Buscar pelo Modelo");
                    System.out.println("6 - Buscar pela Marca");
                    System.out.println("7 - Voltar ao Menu de Busca");
                    System.out.print("? - Sua escolha: ");
                    escolhaBuscaTodos = scNum.nextInt();
                    break;

                case 4:
                    System.out.println("\n==== Visualizar Vans ====");
                    System.out.println("1 - Disponíveis");
                    System.out.println("2 - Alugadas");
                    System.out.println("3 - Em Manutenção");
                    System.out.println("4 - Buscar pela Placa");
                    System.out.println("5 - Buscar pelo Modelo");
                    System.out.println("6 - Buscar pela Marca");
                    System.out.println("7 - Voltar ao Menu de Busca");
                    System.out.print("? - Sua escolha: ");
                    escolhaBuscaTodos = scNum.nextInt();
                    break;

                case 5:
                    System.out.println("\n==== Visualizar Todos Apagados ====");
                    System.out.println("1 - Disponíveis");
                    System.out.println("2 - Alugados");
                    System.out.println("3 - Em Manutenção");
                    System.out.println("4 - Buscar pela Placa");
                    System.out.println("5 - Buscar pelo Modelo");
                    System.out.println("6 - Buscar pela Marca");
                    System.out.println("7 - Voltar ao Menu de Busca");
                    System.out.print("? - Sua escolha: ");
                    escolhaBuscaTodos = scNum.nextInt();
                    break;
            
                case 6:
                    System.out.println("");
                    break;
                default:
                    System.out.println(" \n-- Escolha Inválida --\n");
                    break;
            }
    	
			}catch (Exception e) {
		        e.printStackTrace();
		    }
    	}
    	
    

    
}