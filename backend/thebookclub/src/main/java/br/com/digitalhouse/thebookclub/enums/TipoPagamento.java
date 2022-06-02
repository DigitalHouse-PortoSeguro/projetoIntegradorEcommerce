package br.com.digitalhouse.thebookclub.enums;

public enum TipoPagamento {
	
	CREDITO(1),
	DEBITO(2),
	PIX(3),
	BOLETO(4),
	TRANSFERBANCARIA(5);
	
	private int valor;
	
	private TipoPagamento(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static TipoPagamento valueOf(int valor){
		for(TipoPagamento value : TipoPagamento.values() ){
			if(valor == value.getValor()){
				return value;
			}
		}
		throw new IllegalArgumentException("Tipo de Pagamento Inválido");
	}
}
