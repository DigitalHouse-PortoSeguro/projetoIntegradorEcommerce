import { Pedido } from "./Pedido";

export class Usuario {
    public usuarioId: number;
    public nome: string;
    public sobrenome: string;
    public cpf: string;
    public username: string;
    public tipoUsuario: string;
    public email: string;
    public senha: string;
    public dataNascimento: Date;
    public preferencias?: string;
    public rua: string;
    public numero: number;
    public bairro: string;
    public cep: string;
    public complemento?: string;
    //relacionamentos:
    public pedidos: Pedido[];
}


