import { Livro } from "./Livro";
import { Pedido } from "./Pedido";

export class PedidoLivro {
    public pedidoLivroId: number;
    public quantidade: number;
    public precoVenda: number;
    //relacionamentos:
    public livro:Livro;
    public pedido: Pedido;

}