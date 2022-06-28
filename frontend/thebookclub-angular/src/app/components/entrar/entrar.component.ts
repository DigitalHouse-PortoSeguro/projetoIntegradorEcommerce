import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';
import { UsuarioService } from 'src/app/service/usuario.service';
import { globals } from 'src/environments/environment.prod';

@Component({
  selector: 'app-entrar',
  templateUrl: './entrar.component.html',
  styleUrls: ['./entrar.component.css']
})
export class EntrarComponent implements OnInit {
  username = '';
  senha = '';

  constructor(private authService: UsuarioService, private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    let usuario = new UsuarioLogin;
    usuario.username = this.username;
    usuario.senha = this.senha;
      this.authService.logarUsuario(usuario).subscribe({
        next: user => {
          globals.usuarioLogin = user;
          this.router.navigate(['inicio']);
          console.log(user);
        },

        error: error => {
          console.log(error);
          alert('Usuário ou senha inválidos');
        }
      })
    }
}

