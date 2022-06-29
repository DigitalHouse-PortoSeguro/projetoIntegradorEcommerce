import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-livro-cadastro',
  templateUrl: './livro-cadastro.component.html',
  styleUrls: ['./livro-cadastro.component.css']
})
export class LivroCadastroComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (!this.usuarioService.isLoggedIn()) {
      this.router.navigate(['entrar']);
      return;
    }
    if (this.usuarioService.isLoggedIn() && !this.usuarioService.isAdmin()) {
      this.router.navigate(['inicio']);
      return;
    }
  }

}
