import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/modelos/Usuario';
import { AlertasService } from 'src/app/service/alertas.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService,
    private alertaService: AlertasService,
    private router: Router
	) { }

  ngOnInit(): void {
    if (this.usuarioService.isLoggedIn() && !this.usuarioService.isAdmin()) {
      this.router.navigate(['/inicio']);
      return;
    }
  }

  cadastrar(usuario: Usuario): void {
    this.usuarioService.cadastrarUsuario(usuario).subscribe({
      next: resp => {
        this.alertaService.showAlertSucess('Usuário cadastrado com sucesso!');
        this.router.navigate(['/entrar']);
      },
      error: err => {
        if (err.error?.message) {
          this.alertaService.showAlertDanger(err.error.message);
        } else {
          this.alertaService.showAlertDanger('Aconteceu um erro');
        }
        console.log(err);
      }
    })
  }

  isAdmin(): boolean {
    return this.usuarioService.isAdmin();
  }

}
