package appAluguel;
import conexaoBanco.*;
import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String [] args) {
		Scanner scStr = new Scanner(System.in);
    	Scanner scNum = new Scanner(System.in);
  
    	int escolhaMenu;
    	
    	do {
    	escolhaMenu = Main.menuAPP();
		switch (escolhaMenu) {
			case 1:
				Veiculo.cadastrar_veiculo(scStr, scNum);
				break;
			case 2:
				Veiculo.buscar_veiculos(scStr, scNum);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				System.out.println("\n╔═════════════════════════════════════╗");
		        System.out.println("║        SISTEMA ENCERRADO...         ║");
		        System.out.println("╚═════════════════════════════════════╝");
				break;
			default:
				System.out.println("╔═════════════════════════════════════╗");
		        System.out.println("║           ESCOLHA INVÁLIDA          ║");
		        System.out.println("╚═════════════════════════════════════╝");
				break;
			}
    	}while(escolhaMenu != 0);
	}
	

	//---------------------------------------------------------------------------------
	
	public static int menuAPP() {
		try {	
		Scanner scNum = new Scanner(System.in);
			System.out.println("╔═════════════════════════════════════╗");
	        System.out.println("║    SISTEMA DE ALUGUEL DE VEÍCULOS   ║");
	        System.out.println("╚═════════════════════════════════════╝");
			System.out.println("1 - 📝 Cadastrar Veículo");  
			System.out.println("2 - 🔍 Buscar Veículos");  
			System.out.println("3 - 📝 Alugar Veículo");  
			System.out.println("4 - ✏️ Editar Veículo");  
			System.out.println("5 - 🗑️ Remover Veículo");  
			System.out.println("0 - 👋 Sair do Sistema"); 
			System.out.println("══════════════════════════════════════");
			System.out.print("? - Sua escolha: ");
			int escolhaUsuario = scNum.nextInt();
			
			switch (escolhaUsuario) {
				case 1:
					return 1;
				case 2:
					return 2;
				case 3:
					return 3;
				case 4:
					return 4;
				case 5:
					return 5;
				case 0:
					return 0;
				default:
					return -1;
			}
			
		}catch (InputMismatchException e) {
			System.out.println("\n❌ Erro: Digite apenas números.");
			return -2;
		}
	}
}