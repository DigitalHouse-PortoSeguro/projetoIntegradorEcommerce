import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario-atualizar-admin',
  templateUrl: './usuario-atualizar-admin.component.html',
  styleUrls: ['./usuario-atualizar-admin.component.css']
})
export class UsuarioAtualizarAdminComponent implements OnInit {

  usuario: Usuario;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private route: ActivatedRoute
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

    this.route.paramMap.subscribe(params => {
      const id: number = Number(params.get('id'));
      this.usuarioService.getById(id).subscribe({
        next: resp => {
          this.usuario = resp;
          console.log(resp);
        },
        error: err => {
          alert('Um erro aconteceu...');
          console.log(err);
        }
      });
    });
  }

  atualizar(usuario: Usuario): void {
    this.usuarioService.atualizarUsuario(usuario).subscribe({
      next: resp => {
        this.router.navigate(['admin/gerenciar-usuario', resp.usuarioId]);
        alert('Usuário atualizado com sucesso!');
      },
      error: err => {
        console.log(err);
        alert('Um erro aconteceu...');
      }
    })
  }
}
