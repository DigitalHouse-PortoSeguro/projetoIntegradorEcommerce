import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';
import { AlertasService } from 'src/app/service/alertas.service';
import { UsuarioService } from 'src/app/service/usuario.service';
import { globals } from 'src/environments/environment';

@Component({
  selector: 'app-entrar',
  templateUrl: './entrar.component.html',
  styleUrls: ['./entrar.component.css']
})
export class EntrarComponent implements OnInit {
  username = '';
  senha = '';

  constructor(
    private authService: UsuarioService,
    private router: Router,
    private alertaService: AlertasService
  ) { }

  ngOnInit(): void {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/inicio']);
      return
    }
  }

  login(){
    let usuario = new UsuarioLogin;
    usuario.username = this.username;
    usuario.senha = this.senha;
      this.authService.logarUsuario(usuario).subscribe({
        next: user => {
          globals.usuarioLogin = user;
          this.authService.saveUsuarioLocalStorage();
          this.alertaService.showAlertSucess('Usuário logado com sucesso!');
          if (globals.carrinho.pedidoLivros.length > 0) {
            this.router.navigate(['/carrinho']);
          } else {
            this.router.navigate(['/inicio']);
          }
          console.log(user);
        },

        error: error => {
          console.log(error);
          this.alertaService.showAlertDanger('Usuário ou senha inválidos');
        }
      })
    }
}


