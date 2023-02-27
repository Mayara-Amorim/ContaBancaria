package br.com.gen.conta.repository;

import br.com.gen.conta.model.Conta;

public interface ContaRepository {
//	CRUD
	
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
//  Metodos Bancarios
	public void sacar(int numero, float valor);
	public void transferir(int nOrigem, int nDestino, float valor);
	public void depositar (int nDestino,float valor);
	public void procurarPorNumero(int numero);
	
	
	
	
}
