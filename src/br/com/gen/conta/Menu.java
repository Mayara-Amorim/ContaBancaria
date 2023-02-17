package br.com.gen.conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int op;
		while (true) {
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("            BANCO DO BRAZIL COM Z            ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("            1- Criar Conta                   ");
			System.out.println("            2- Listar todas as contas        ");
			System.out.println("            3- Buscar conta por numero       ");
			System.out.println("            4- Atualizar dados da conta      ");
			System.out.println("            5- Apagar conta                  ");
			System.out.println("            6- Sacar                         ");
			System.out.println("            7- Depositar                     ");
			System.out.println("            8- Transferir                    ");
			System.out.println("            9- Sair                          ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("          Entre com a opção desejada:        ");
			System.out.println("                                             ");

			op = leia.nextInt();
			if (op == 9) {
				System.out.println(" O Banco agradece: Seu futuro é aqui!!! ");
				leia.close();
				System.exit(0);
			}

			switch (op) {
			case 1:
				System.out.println("Criar uma conta\n\n");
				break;
			case 2:
				System.out.println("Listar todas as contas\n\n");
				break;
			case 3:
				System.out.println("Consultar  os dados da Conta\n\n");
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println("Apagar a conta\n\n");
				break;
			case 6:
				System.out.println("Sacar\n\n");
				break;
			case 7:
				System.out.println("Depositar\n\n");
				break;
			case 8:
				System.out.println("Transferir\n\n");
				break;
			default:
				System.out.println("\nOpção invalida!\n");
				break;

			}
		}
	}
}
