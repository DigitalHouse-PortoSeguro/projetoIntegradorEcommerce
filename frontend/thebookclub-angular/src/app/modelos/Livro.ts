import { LocalDate } from "../utils/LocalDate";
import { PedidoLivro } from "./PedidoLivro";
export class Livro {
    public livroId: number;
    public titulo: string;
    public foto: string;
    public dataPublicacao: LocalDate;
    public autores: string;
    public editora: string;
    public categoria: string;
    public sinopse: string;
    public numeroPaginas: number;
    public isbn: string;
    public preco: number;
    public quantidadeEstoque: number;
    public fornecedor: string;
    
    //relacionamentos:
    public pedidoLivros: PedidoLivro[];
}