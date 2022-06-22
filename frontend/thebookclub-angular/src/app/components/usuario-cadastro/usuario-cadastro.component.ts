import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
	) { }

  ngOnInit(): void {
    if (this.usuarioService.isLoggedIn() && !this.usuarioService.isAdmin()) {
      this.router.navigate(['inicio']);
      return;
    }
  }

  cadastrar(usuario: Usuario): void {
    this.usuarioService.cadastrarUsuario(usuario).subscribe({
      next: resp => {
        console.log(resp);
        this.router.navigate(['login']);
        alert('Usuário cadastrado com sucesso!');
      },
      error: err => {
        console.log(err);
        alert('Um erro aconteceu...');
      }
    })
  }

  isAdmin(): boolean {
    return this.usuarioService.isAdmin();
  }

}
