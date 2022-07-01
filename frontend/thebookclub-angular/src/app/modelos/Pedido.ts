import { LocalDateTime } from "../utils/LocalDate";
import { PedidoLivro } from "./PedidoLivro";
import { Usuario } from "./Usuario";

export class Pedido {
    public pedidoId: number;
    public valor: number;
    public tipoPagamento: string;
    public formaEnvio: string;
    public status: string;
    public dataPedido: LocalDateTime;
    public dataEntrega: LocalDateTime;
    //relacionamentos:
    public usuario: Usuario;
    public pedidoLivros: PedidoLivro[];
}