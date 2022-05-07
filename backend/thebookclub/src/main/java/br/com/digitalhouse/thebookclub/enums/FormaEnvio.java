package br.com.digitalhouse.thebookclub.enums;

public enum FormaEnvio {
	
	CORREIOS(1), 
	RETIRADANALOJA(2),
	TRANSPORTADORA(3);
	
	private int valor;
	
	FormaEnvio(int index){
		this.valor = index;
	}
	
	public int getIndex() {
		return valor;
	}
}
