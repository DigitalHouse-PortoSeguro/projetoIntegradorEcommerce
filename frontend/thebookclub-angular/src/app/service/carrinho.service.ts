import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment, globals } from 'src/environments/environment';
import { Pedido } from '../modelos/Pedido';
import { PedidoLivro } from '../modelos/PedidoLivro';
import { Usuario } from '../modelos/Usuario';
import { LocalDateTime } from '../utils/LocalDate';

@Injectable({
	providedIn: 'root'
})
export class CarrinhoService {
	constructor(
		private http: HttpClient
	) { }

	private atualizarCarrinhoInfo(): void {
		globals.carrinho.valor = 0;

		for (const pedido of globals.carrinho.pedidoLivros) {
			globals.carrinho.valor += pedido.precoVenda * pedido.quantidade;
		}
	}

	public resetar(): void {
		globals.carrinho = new Pedido();
		globals.carrinho.pedidoLivros = [];
		globals.carrinho.valor = 0;
		globals.carrinho.status = "AGUARDANDO_PAGAMENTO";
		localStorage.removeItem("__USER_CART");
	}

	public adicionarPedidoLivro(pedidoLivro: PedidoLivro): void {
		//pedidoLivro.pedido = globals.carrinho;
		globals.carrinho.pedidoLivros.push(pedidoLivro);
		this.atualizarCarrinhoInfo();
	}

	public getPedidoLivroAtIndex(i: number): PedidoLivro {
		return globals.carrinho.pedidoLivros[i];
	}

	public setPedidoLivroAtIndex(i: number, pedidoLivro: PedidoLivro): void {
		//pedidoLivro.pedido = globals.carrinho;
		globals.carrinho.pedidoLivros[i] = pedidoLivro;
		this.atualizarCarrinhoInfo();
	}

	public getAllPedidoLivros(): PedidoLivro[] {
		return globals.carrinho.pedidoLivros;
	}

	public getTotal(): number {
		return globals.carrinho.valor;
	}

	public removerPedidoLivroAtIndex(i: number): void {
		globals.carrinho.pedidoLivros.splice(i, 1);
	}

	public saveCarrinhoLocalStorage(): void {
		localStorage.setItem("__USER_CART", JSON.stringify(globals.carrinho));
	}

	public loadCarrinhoLocalStorage(): void {
		const cartItem = localStorage.getItem("__USER_CART");
		if (cartItem != null) {
			const cartObj = JSON.parse(cartItem);
			Object.assign(globals.carrinho, cartObj);
		} else {
			globals.carrinho.pedidoLivros = [];
			globals.carrinho.valor = 0;
			globals.carrinho.status = "AGUARDANDO_PAGAMENTO";
		}
	}

	public checkoutCarrinho(tipoPagamento: string, formaEnvio: string): Observable<Pedido> {
		const headers = new HttpHeaders()
			.set('Authorization', globals.usuarioLogin.token);

		const dataPedido = new LocalDateTime(Date.now());
		const dataEntrega = new LocalDateTime(Date.now());
		// Tempo de entrega aleatório entre 1 e 10 dias
		const tempoDeEntrega = 1 + Math.round(Math.random() * 9);
		dataEntrega.setDate(dataEntrega.getDate() + tempoDeEntrega);

		const usuario = new Usuario();
		usuario.usuarioId = globals.usuarioLogin.usuarioId;

		globals.carrinho.tipoPagamento = tipoPagamento;
		globals.carrinho.formaEnvio = formaEnvio;
		globals.carrinho.status = "PAGTO_APROVADO";
		globals.carrinho.dataPedido = dataPedido;
		globals.carrinho.dataEntrega = dataEntrega;
		globals.carrinho.usuario = usuario;

		return this.http.post<Pedido>(
			`${environment.BASE_URL}/pedidos/cadastrar`,
			globals.carrinho,
			{ headers }
		);
	}
}
