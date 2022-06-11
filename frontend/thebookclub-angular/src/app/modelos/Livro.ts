import { PedidoLivro } from "./PedidoLivro";

export class Livro {
    public livroId: number;
    public titulo: string;
    public dataPublicacao: Date;
    public autores: string;
    public editora: string;
    public categoria: string;
    public numeroPaginas: number;
    public isbn: string;
    public preco: number;
    public quantidadeEstoque: number;
    public fornecedor: string;
    //relacionamentos:
    public pedidoLivro: PedidoLivro[];
}