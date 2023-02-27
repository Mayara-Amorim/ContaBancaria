package br.com.gen.conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.gen.conta.controller.ContaController;
import br.com.gen.conta.model.ContaCorrente;
import br.com.gen.conta.model.ContaPoupanca;

public class MenuConta {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		ContaController contas = new ContaController();
		int op, numero, agencia, tipo, destino;
		float saldo, limite, valor;
		String titular, aniversario;
		ContaCorrente cc1= new ContaCorrente(contas.gerarNumero(), 1, 1,"João da Silva", 1000f, 11050);
		ContaCorrente cc2= new ContaCorrente(contas.gerarNumero(), 33, 1,"Marcela Carla", 1000f, 17000);
		ContaPoupanca cp1= new ContaPoupanca(contas.gerarNumero(), 24, 2,"cARLOS eDUARDO Guimaraes", 1000f, "25/10/1990");
		ContaPoupanca cp2= new ContaPoupanca(contas.gerarNumero(), 64, 2,"cRISTINA Oliveira", 1000f, "03/03/2016");
		
		contas.cadastrar(cc1);
		contas.cadastrar(cc2);
		contas.cadastrar(cp1);
		contas.cadastrar(cp2);
		contas.listarTodas();
		
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
			try {
				op = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros");
				leia.nextLine();
				op = 0;
			}

			if (op == 9) {
				System.out.println(" O Banco agradece: Seu futuro é aqui!!! ");
				leia.close();
				System.exit(0);
			}

			switch (op) {
			case 1:
				System.out.println("Criar uma conta\n\n");
				System.out.println("Digite o numero da agencia:");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular:");
				leia.skip("\\R?");
				titular = leia.nextLine();
				do {
					System.out.println("Digite 1 para ContaCorrente ou 2 para ContaPoupança ");
					tipo = leia.nextInt();

				} while (tipo < 1 && tipo > 2);
				System.out.println("Digite o saldo da conta: ");
				saldo = leia.nextFloat();
				switch (tipo) {
				case 1 -> {
					System.out.println("Digite um limite: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));

				}
				case 2 -> {
					System.out.println("Digite seu aniversario conta: ");
					aniversario = leia.nextLine();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}
				}
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println("Consultar  os dados da Conta\n\n");
				System.out.println("Qual o numero da sua conta: \n\n");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				System.out.println("Digite o numero da conta:");
				numero = leia.nextInt();
				
				if(contas.buscaNaCollection(numero) != null) {
					System.out.println("Digite o numero da agencia:");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular:");
				leia.skip("\\R?");
				titular = leia.nextLine();
				System.out.println("Digite os saldo");
				saldo = leia.nextFloat();
				
				tipo = contas.retornaTipo(numero);
				switch (tipo) {
				case 1 -> {
				System.out.println("Digite o limite da Conta (R$): ");
				limite = leia.nextFloat();
				contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniver da sua conta: ");
					aniversario = leia.next();
					contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
				}
				default -> {
					System.out.println("Tipo de conta invalido");
				}
				}
				}else 
					System.out.println("Conta não encontrada");
				
				keyPress();
				break;
			
			case 5:
				System.out.println("Apagar a conta\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println("Sacar\n\n");
				System.out.println("Digite o numero da conta de destino:");
				destino = leia.nextInt();
				do {
					System.out.println("Digite o valor que deseja sacar: ");
				valor = leia.nextFloat();
				}while(valor<0);
				contas.sacar(destino, valor);
				
				break;
			case 7:
				System.out.println("Depositar\n\n");
				System.out.println("Digite o numero da conta:");
				destino = leia.nextInt();
				do {
					System.out.println("Digite o valor que deseja depositar: ");
					valor = leia.nextFloat();
				} while (valor<0);
				contas.depositar(destino, valor);
				break;
			case 8:
				System.out.println("Transferir\n\n");
				System.out.println("Digite o numero da conta origem:");
				numero = leia.nextInt();
				System.out.println("Digite o numero da conta de destino:");
				destino = leia.nextInt();
				do {
					System.out.println("Digite o valor que deseja transferir:");
					valor = leia.nextFloat();
				} while (valor<0);
				System.out.println("Sua transferencia foi realizada com sucesso");
				contas.transferir(numero, destino, valor);
				
				break;
			default:
				System.out.println("\nOpção invalida!\n");
				break;

			}
		}
	}

	public static void keyPress() {
		try {

			System.out.println("Precione enter para continuar");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Voce precionou uma tecla diferente");

		}
	}
}
