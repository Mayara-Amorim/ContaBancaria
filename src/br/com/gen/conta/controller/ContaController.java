package br.com.gen.conta.controller;

import java.util.ArrayList;
import br.com.gen.conta.model.Conta;
import br.com.gen.conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta>listaContas = new ArrayList<>();
	
	@Override
	public void procurarPorNumero(int numero) {
	var conta =  buscaNaCollection(numero);
	if(conta != null) {
		conta.visualizar();
	}else {
		System.out.println("A conta" + numero + " não foi encontrada");
	}
		
	}

	@Override
	public void listarTodas() {
		//for (var conta : listaContas)
		 for (Conta conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta numero " + conta.getNumero() + " foi criada com sucesso");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscaNaCollection(conta.getNumero());
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A conta numero" + conta.getNumero() + " foi atualizada");
			
		}else {
			System.out.println("Não foi encontrada essa conta!");
		}
		 
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscaNaCollection (numero);
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.println("Conta numero " + numero + " foi apagada");
			}else {
				System.out.println("Essa conta não foi encontrada");
			}
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var buscaConta = buscaNaCollection(numero);
		if (buscaConta !=null) {
			if(listaContas.get(listaContas.indexOf(buscaConta)).sacar(valor) == true);
			System.out.println("Foi efetuado saque no valor de " + valor + " na conta numero: " + numero);
			
		}else {
			System.out.println("A conta numero: " + numero + "não foi encontrada");
		}
		
	}

	@Override
	public void transferir(int nOrigem, int nDestino, float valor) {
		var contaOrigem = buscaNaCollection(nOrigem);
		var contaDestino = buscaNaCollection(nDestino);
		if(contaOrigem != null && contaDestino != null) {
			if(listaContas.get(listaContas.indexOf(contaOrigem)).sacar(valor) == true) {
				listaContas.get(listaContas.indexOf(contaDestino)).depositar(valor);
				System.out.println("Transferencia efetuada com sucesso");
			}else {
				System.out.println("Verifique o numero da conta destino ou origem e tente novamente");
			}
		}
		
	}

	@Override
	public void depositar(int nDestino, float valor) {
		 var buscaConta = buscaNaCollection(nDestino);
		 if(buscaConta != null) {
			 var indiceConta = listaContas.indexOf(buscaConta);
			 listaContas.get(indiceConta).depositar(valor);
			 System.out.println("O valor foi depositado na conta" + nDestino);
		 }else {
			 System.out.println("Essa conta não existe");
		 }
		
	}
	public int gerarNumero() {
		return listaContas.size() + 1;

	}
	public Conta buscaNaCollection(int numero) {
		for (var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
		
	}
	public int retornaTipo(int numero) {
		for (var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta.getTipo();
			}
			
		}
			return 0;
	}

}
