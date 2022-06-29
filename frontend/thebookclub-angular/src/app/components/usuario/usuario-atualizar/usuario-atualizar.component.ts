import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';
import { UsuarioService } from 'src/app/service/usuario.service';
import { globals } from 'src/environments/environment';

@Component({
  selector: 'app-usuario-atualizar',
  templateUrl: './usuario-atualizar.component.html',
  styleUrls: ['./usuario-atualizar.component.css']
})
export class UsuarioAtualizarComponent implements OnInit {

  user: Usuario;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (!this.usuarioService.isLoggedIn()) {
      this.router.navigate(['entrar']);
      return;
    }
    this.user = this.usuarioService.getUsuario();
  }

  atualizar(usuario: Usuario): void {
    this.usuarioService.atualizarUsuario(usuario).subscribe({
      next: resp => {
        console.log(resp);
        const login = new UsuarioLogin();
        login.username = usuario.username;
        login.senha = usuario.senha;

        this.usuarioService.logarUsuario(login).subscribe({
          next: user => {
            globals.usuarioLogin = user;
            this.usuarioService.saveUsuarioLocalStorage();
            this.router.navigate(['inicio']);
            alert('Usuário atualizado com sucesso!');
          },
          error: err => {
            console.log(err);
            alert('Um erro aconteceu...');
          }
        });
      },
      error: err => {
        console.log(err);
        alert('Um erro aconteceu...');
      }
    })
  }

}
