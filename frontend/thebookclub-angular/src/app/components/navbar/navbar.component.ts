import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  tituloText: string = "";

  constructor(
    private router: Router,
    private usuarioService: UsuarioService
  ) { }

  ngOnInit() {
  }

  buscaTitulo() {
    if (this.tituloText == "") return;

    this.router.navigate(['/livros/titulo', this.tituloText]);
  }

  loggedIn(): boolean {
    return this.usuarioService.isLoggedIn();
  }
  isAdmin(): boolean {
    return this.usuarioService.isAdmin();
  }

  getUser(): UsuarioLogin {
    return this.usuarioService.getUsuarioLogin();
  }

}
