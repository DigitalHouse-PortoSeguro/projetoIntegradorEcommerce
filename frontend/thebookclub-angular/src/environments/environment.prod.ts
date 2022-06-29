import { Pedido } from 'src/app/modelos/Pedido';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';

export const environment = {
	production: true
};

type GlobalVariables = {
	usuarioLogin: UsuarioLogin,
	carrinho: Pedido,
	BASE_URL: string
};
const BASE_URL: string = "https://thebookclub-dhporto.herokuapp.com" 

//variáveis globais para usuário login
export const globals: GlobalVariables = {
	usuarioLogin: new UsuarioLogin(),
	carrinho: new Pedido(),
	BASE_URL: BASE_URL

}

