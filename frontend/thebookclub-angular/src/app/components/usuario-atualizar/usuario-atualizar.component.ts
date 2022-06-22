import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

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
      this.router.navigate(['cadastrar']);
      return;
    }
    this.user = this.usuarioService.getUsuario();
  }

  atualizar(usuario: Usuario): void {
    this.usuarioService.atualizarUsuario(usuario).subscribe({
      next: resp => {
        console.log(resp);
        this.usuarioService.logout();
        this.router.navigate(['login']);
        alert('Usuário atualizado com sucesso!');
      },
      error: err => {
        console.log(err);
        alert('Um erro aconteceu...');
      }
    })
  }

}
