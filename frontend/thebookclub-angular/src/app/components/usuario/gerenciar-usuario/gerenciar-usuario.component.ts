import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioService } from 'src/app/service/usuario.service';
import { globals } from 'src/environments/environment';

@Component({
  selector: 'app-gerenciar-usuario',
  templateUrl: './gerenciar-usuario.component.html',
  styleUrls: ['./gerenciar-usuario.component.css']
})
export class GerenciarUsuarioComponent implements OnInit {

  usuario: Usuario;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    if (!this.usuarioService.isLoggedIn()) {
      this.router.navigate(['/entrar']);
      return;
    }
    if (!this.usuarioService.isAdmin()) {
      this.router.navigate(['/inicio']);
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

  atualizarUsuario(): void {
    this.router.navigate(['/admin/usuarios/atualizar', this.usuario.usuarioId]);
  }

  deletarUsuario(): void {
    this.usuarioService.deleteById(this.usuario.usuarioId).subscribe({
      next: resp => {
        alert('Usuário deletado com sucesso!');
        this.router.navigate(['/admin/usuarios/lista']);
      },
      error: err => {
        console.log(err);
        alert('Um erro aconteceu...');
      }
    })
  }

  usuarioLogado(): boolean {
    return globals.usuarioLogin.username === this.usuario.username;
  }
}
