import { PedidoLivro } from "./PedidoLivro";
import { Usuario } from "./Usuario";

export class Pedido {
    public pedidoId: number;
    public valor: number;
    public pagamento: string;
    public formaEnvio: string;
    public status: string;
    public dataPedido: Date;
    public dataEntrega: Date;
    //relacionamentos:
    public usuario: Usuario;
    public pedidoLivro: PedidoLivro[];
}