import { Pedido } from 'src/app/modelos/Pedido';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';

export const environment = {
	production: true
};

type GlobalVariables = {
	usuarioLogin: UsuarioLogin,
	carrinho: Pedido
};

//variáveis globais para usuário login
export const globals: GlobalVariables = {
	usuarioLogin: new UsuarioLogin(),
	carrinho: new Pedido()
}

