import { LocalDate } from "../utils/LocalDate";

export class UsuarioLogin {
    public usuarioId: number;
    public nome: string;
    public sobrenome: string;
    public cpf: string;
    public username: string;
    public tipoUsuario: string;
    public email: string;
    public senha: string;
    public dataNascimento: LocalDate;
    public preferencias?: string;
    public rua: string;
    public numero: number;
    public bairro: string;
    public cep: string;
    public complemento?: string;
    public foto: string;
    public token: string;
}


