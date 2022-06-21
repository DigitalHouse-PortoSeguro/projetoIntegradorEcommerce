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
    user.cpf = "131.131.131-03"
    user.dataNascimento = LocalDate.fromString("2002-11-25")
    user.email = "ghsoares99795@gmail.com"
    user.nome = "Gabriel Henrique"
    user.numero = 100
    user.preferencias = "";
    user.rua = "Mauro D' Araújo Ribeiro"
    user.senha = "$2a$10$s5WHHaUrkJeWfC7.n2o3XuvHlKytNOm0VcNp/uQg1uzZ.NSgba/yG"
    user.sobrenome = "Pereira Soares"
    user.tipoUsuario = "COMUM"
    user.username = "ghsoares"
    user.usuarioId = 1
    user.token = "Basic " + btoa("ghsoares:Senha123")

    //globals.usuarioLogin = user;
  }
}
