import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-listar-usuarios',
  templateUrl: './listar-usuarios.component.html',
  styleUrls: ['./listar-usuarios.component.css']
})
export class ListarUsuariosComponent implements OnInit {

  usuarios: Usuario[] = [];

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (!this.usuarioService.isLoggedIn()) {
      this.router.navigate(['entrar']);
      return;
    }
    if (!this.usuarioService.isAdmin()) {
      this.router.navigate(['inicio']);
      return;
    }

    this.usuarioService.getAllUsuarios().subscribe({
      next: resp => {
        this.usuarios = resp;
      },
      error: err => {
        alert('Um erro aconteceu...');
        console.log(err);
      }
    });
  }

  gerenciar(usuarioId: number): void {
    this.router.navigate(['admin/gerenciar-usuario', usuarioId]);
  }

}
