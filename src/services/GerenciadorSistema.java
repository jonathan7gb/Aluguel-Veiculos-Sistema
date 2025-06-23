package services;

import java.sql.*;
import java.util.*;

import conexaoBanco.*;
import model.Veiculo;
import views.*;


public class GerenciadorSistema {

	 public static void cadastrar_veiculo(Scanner scStr, Scanner scNum) {
	    	try (Connection conn = Conexao.getConexao()) {
	    		
	            String tipo = "";

	            System.out.println("\n╔═════════════════════════════════════╗");
		        System.out.println("║          CADASTRAR VEÍCULO          ║");
		        System.out.println("╚═════════════════════════════════════╝");
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
	                	System.out.println("\n╔═════════════════════════════════════╗");
	    		        System.out.println("║           ESCOLHA INVÁLIDA          ║");
	    		        System.out.println("╚═════════════════════════════════════╝\n");
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
	                	System.out.println("\n╔═════════════════════════════════════╗");
	    		        System.out.println("║      ANO DE FABRICAÇÃO INVÁLIDO     ║");
	    		        System.out.println("╚═════════════════════════════════════╝\n");
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

	                    System.out.println("\n╔═════════════════════════════════════╗");
	        	        System.out.println("║    VEÍCULO CADASTRADO COM SUCESSO   ║");
	        	        System.out.println("╚═════════════════════════════════════╝\n");
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

	    //---------------------------------------------------------------------------
	    	
	    	public static void buscar_veiculos(Scanner scStr, Scanner scNum) {
	    		try (Connection conn = Conexao.getConexao()) {

	    		int escolhaBuscaPrincipal = 0;
	    		int escolhaBuscaTodos = 0;
	    		boolean encontrado = false;

	            menu_busca_principal();
	            System.out.print("? - Sua escolha: ");
	            escolhaBuscaPrincipal = scNum.nextInt();

	            switch (escolhaBuscaPrincipal) {
	                case 1:
	                    VeiculosViews.menu_busca_todos();
	                    System.out.print("? - Sua escolha: ");
	                    escolhaBuscaTodos = scNum.nextInt();
	                    Thread.sleep(300); 

	                    switch(escolhaBuscaTodos) {
	                    	case 1:
	                            VeiculosViews.todos_veiculos_disponiveis();
	                            break;
	                    	case 2:
	                            VeiculosViews.todos_veiculos_alugados();
	                    		break;
	                    	case 3:
	                            VeiculosViews.View_todos_veiculos_manutenção();
	                    		break;
	                    	case 4:
	                            VeiculosViews.buscar_veiculo_placa();
	                    		break;
	                    	case 5:
	                            VeiculosViews.buscar_veiculo_modelo();
	                    		break;
	                    	case 6:
	                            VeiculosViews.buscar_veiculo_marca();
	                    		break;
	                    	case 7:
	                            VeiculosViews.listar_todos_veiculos();
	                    		break;
	                    	case 0:
	                            System.out.println("");
	                            break;
	                        default:
	                        	System.out.println("\n╔═════════════════════════════════════╗");
	            		        System.out.println("║           ESCOLHA INVÁLIDA          ║");
	            		        System.out.println("╚═════════════════════════════════════╝\n");
	                            break;
	                    }
	                    break;

	                case 2:
	                    CarrosViews.menu_busca_carro();
	                    System.out.print("? - Sua escolha: ");
	                    int escolhaBuscaCarro = scNum.nextInt();
	                    Thread.sleep(300); 

	                    switch(escolhaBuscaCarro) {
	                    	case 1:
	                            CarrosViews.todos_carros_disponiveis();
	                            break;
	                    	case 2:
	                            CarrosViews.todos_carros_alugados();
	                    		break;
	                    	case 3:
	                            CarrosViews.todos_carros_manutencao();
	                    		break;
	                    	case 4:
	                            CarrosViews.buscar_carro_pela_placa();
	                    		break;
	                    	case 5:
	                            CarrosViews.buscar_carro_pelo_modelo();;
	                    		break;
	                    	case 6:
	                            CarrosViews.buscar_carro_pela_marca();
	                    		break;
	                    	case 7:
	                    		CarrosViews.listar_todos_carros();
	                    		break;
	                    	case 0:
	                            System.out.println("");
	                            break;
	                        default:
	                        	System.out.println("\n╔═════════════════════════════════════╗");
	            		        System.out.println("║           ESCOLHA INVÁLIDA          ║");
	            		        System.out.println("╚═════════════════════════════════════╝\n");
	                            break;
	                    }
	                    break;

	                case 3:
	                    MotosViews.menu_busca_moto();
	                    System.out.print("? - Sua escolha: ");
	                    int escolhaBuscaMoto = scNum.nextInt();
	                    Thread.sleep(300); 

	                    switch(escolhaBuscaMoto) {
	                    	case 1:
	                            MotosViews.todas_motos_disponiveis();
	                            break;
	                    	case 2:
	                            MotosViews.todas_motos_alugados();
	                    		break;
	                    	case 3:
	                            MotosViews.todas_motos_manutencao();
	                    		break;
	                    	case 4:
	                            MotosViews.buscar_motos_pela_placa();
	                    		break;
	                    	case 5:
	                            MotosViews.buscar_motos_pelo_modelo();
	                    		break;
	                    	case 6:
	                            MotosViews.buscar_motos_pela_marca();
	                    		break;
	                    	case 7:
	                    		MotosViews.listar_todas_motos();
	                    		break;
	                    	case 0:
	                            System.out.println("");
	                            break;
	                        default:
	                        	System.out.println("\n╔═════════════════════════════════════╗");
	            		        System.out.println("║           ESCOLHA INVÁLIDA          ║");
	            		        System.out.println("╚═════════════════════════════════════╝\n");
	                            break;
	                    }
	                    break;

	                case 4:
	                	VansViews.menu_busca_van();
	                    System.out.print("? - Sua escolha: ");
	                    int escolhaBuscaVan = scNum.nextInt();
	                    Thread.sleep(300); 

	                    switch(escolhaBuscaVan) {
	                    	case 1:
	                            VansViews.todas_vans_disponiveis();
	                            break;
	                    	case 2:
	                            VansViews.todas_vans_alugados();
	                    		break;
	                    	case 3:
	                            VansViews.todas_vans_manutencao();
	                    		break;
	                    	case 4:
	                            VansViews.buscar_vans_pela_placa();
	                    		break;
	                    	case 5:
	                            VansViews.buscar_vans_pelo_modelo();
	                    		break;
	                    	case 6:
	                            VansViews.buscar_vans_pela_marca();
	                    		break;
	                    	case 7:
	                    		VansViews.listar_todas_vans();
	                    		break;
	                    	case 0:
	                            System.out.println("");
	                            break;
	                        default:
	                        	System.out.println("\n╔═════════════════════════════════════╗");
	            		        System.out.println("║           ESCOLHA INVÁLIDA          ║");
	            		        System.out.println("╚═════════════════════════════════════╝\n");
	                            break;
	                    }
	                    break;

	                case 5:
	                    VeiculosViews.View_todos_veiculos_apagados();
	                    break;
	            
	                case 0:
	                    System.out.println("");
	                    break;
	                default:
	                	System.out.println("\n╔═════════════════════════════════════╗");
	    		        System.out.println("║           ESCOLHA INVÁLIDA          ║");
	    		        System.out.println("╚═════════════════════════════════════╝\n");
	                    break;
	            }
	    	
				}catch (InputMismatchException e) {
	                System.out.println("\n🚫 Entrada inválida!\n");
	           }catch (Exception e) {
			        e.printStackTrace();
			    }
	    	}

	        public static void menu_busca_principal(){
	            try{
	            	System.out.println("\n╔═════════════════════════════════════╗");
			        System.out.println("║           BUSCAR VEÍCULOS           ║");
			        System.out.println("╚═════════════════════════════════════╝");
	                System.out.println("1 - Visualizar Todos");
	                Thread.sleep(100); 
	                System.out.println("2 - Visualizar Carros");
	                Thread.sleep(100); 
	                System.out.println("3 - Visualizar Motos");
	                Thread.sleep(100); 
	                System.out.println("4 - Visualizar Vans");
	                Thread.sleep(100); 
	                System.out.println("5 - Visualizar Todos Apagados");
	                Thread.sleep(100); 
	                System.out.println("0 - Voltar ao Menu Principal");
	                Thread.sleep(300); 
	                System.out.println("══════════════════════════════════════");
	            }catch (Exception e) {
			    }
	        }

}
