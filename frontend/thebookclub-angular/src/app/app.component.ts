import { Component } from '@angular/core';
import { globals } from 'src/environments/environment.prod';
import { Livro } from './modelos/Livro';
import { Usuario } from './modelos/Usuario';
import { UsuarioLogin } from './modelos/UsuarioLogin';
import { LocalDate } from './utils/LocalDate';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'thebookclub-angular';

  constructor() { 
    const user = new UsuarioLogin();

    user.bairro = "Jaraguá"
    user.cep = "05182-000"
    user.complemento = ""
    user.cpf = "000.001.005-11"
    user.dataNascimento = LocalDate.fromString("2002-11-25")
    user.email = "ghsoares99796@gmail.com"
    user.nome = "Gabriel Henrique"
    user.numero = 100
    user.preferencias = "";
    user.rua = "Mauro D' Araújo Ribeiro"
    user.senha = "$2a$10$hJ2Pz4Nt4RCKqq.SyEU4NOleL74LsDL7FyW0UdoK8PGub1M4PAuHy"
    user.sobrenome = "Pereira Soares"
    user.tipoUsuario = "ADMIN"
    user.username = "ghsoarez"
    user.usuarioId = 2
    user.token = "Basic " + btoa("ghsoarez:Senha123")

    globals.usuarioLogin = user;
  }
}
