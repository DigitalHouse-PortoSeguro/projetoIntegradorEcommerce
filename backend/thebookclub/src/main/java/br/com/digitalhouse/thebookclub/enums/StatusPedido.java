package br.com.digitalhouse.thebookclub.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PROCESSANDO(2),
	PAGTO_APROVADO(3),
	PAGTO_RECUSADO(4),
	ENVIADO(5),
	ENTREGUE(6);
	
	private int valor;
	
	StatusPedido(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
}
