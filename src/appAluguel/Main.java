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
				Veiculo.buscar_orientacoes(scStr, scNum);
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				System.out.println(" \n-- Sistema Encerrado --");
				break;
			default:
				System.out.println(" \n-- Escolha Inválida --\n");
				break;
			}
    	}while(escolhaMenu != 0);
	}
	
	public static int menuAPP() {
		try {	
		Scanner scNum = new Scanner(System.in);
			System.out.println("===== SISTEMA DE ALGUEL DE VEÍCULOS =====");
			System.out.println("1 - 📝 Cadastrar Veículo");  
			System.out.println("2 - 🔍 Buscar Veículos");  
			System.out.println("3 - ✏️ Editar Veículo");  
			System.out.println("4 - 🗑️ Remover Veículo");  
			System.out.println("0 - 👋 Sair do Sistema"); 
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
				case 0:
					return 0;
				default:
					return -1;
			}
			
		}catch (InputMismatchException e) {
			System.out.println("Erro: Digite apenas números.\n");
			return -1;
		}
	}
}