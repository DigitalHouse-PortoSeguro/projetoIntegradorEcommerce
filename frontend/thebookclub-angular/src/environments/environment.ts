import { Pedido } from 'src/app/modelos/Pedido';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';

type GlobalVariables = {
	usuarioLogin: UsuarioLogin,
	carrinho: Pedido
};

type EnvironmentVariables = {
	production: boolean,
	BASE_URL: string
};

export const environment: EnvironmentVariables = {
	production: false,
	BASE_URL: "http://localhost:8080"
};
environment.BASE_URL = "https://thebookclub-dhporto.herokuapp.com";

//variáveis globais para usuário login
export const globals: GlobalVariables = {
	usuarioLogin: new UsuarioLogin(),
	carrinho: new Pedido()
}

