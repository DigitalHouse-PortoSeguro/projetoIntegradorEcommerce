package br.com.digitalhouse.thebookclub.enums;

public enum TipoPagamento {
	
	CREDITO(1),
	DEBITO(2),
	PIX(3),
	BOLETO(4),
	TRANSFERBANCARIA(5);
	
	private int valor;
	
	TipoPagamento(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
}
