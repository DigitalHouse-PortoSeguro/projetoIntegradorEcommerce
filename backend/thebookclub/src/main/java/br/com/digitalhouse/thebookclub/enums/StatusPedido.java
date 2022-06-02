package br.com.digitalhouse.thebookclub.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	PROCESSANDO(3),
	DESPACHADO(4),
	ENTREGUE(5),
	CANCELADO(6); 
	
	private int valor;
	
	private StatusPedido(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static StatusPedido valueOf(int valor){
		for(StatusPedido value : StatusPedido.values() ){
			if(valor == value.getValor()){
				return value;
			}
		}
		throw new IllegalArgumentException("Status do Pedido Inválido");
	}
}
