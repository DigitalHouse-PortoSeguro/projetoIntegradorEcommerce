package br.com.digitalhouse.thebookclub.enums;

public enum FormaEnvio {
	
	CORREIOS(1), 
	RETIRADANALOJA(2),
	TRANSPORTADORA(3);
	
	private int valor;
	
	private FormaEnvio(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static FormaEnvio valueOf(int valor){
		for(FormaEnvio value : FormaEnvio.values() ){
			if(valor == value.getValor()){
				return value;
			}
		}
		throw new IllegalArgumentException("Forma de Envio Inválida");
	}
}
