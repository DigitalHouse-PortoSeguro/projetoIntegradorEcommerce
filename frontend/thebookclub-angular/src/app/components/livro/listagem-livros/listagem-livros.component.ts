import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Livro } from 'src/app/modelos/Livro';
import { AlertasService } from 'src/app/service/alertas.service';
import { LivroService } from 'src/app/service/livro.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-listagem-livros',
  templateUrl: './listagem-livros.component.html',
  styleUrls: ['./listagem-livros.component.css']
})
export class ListagemLivrosComponent implements OnInit {

  livros: Livro[] = [];

  constructor(
    private usuarioService: UsuarioService,
    private livroService: LivroService,
    private alertaService: AlertasService,
    private router: Router
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
    this.livroService.getAllLivros().subscribe({
      next: resp => {
        this.livros = resp;
      },
      error: err => {
        this.alertaService.showAlertDanger('Um erro aconteceu');
        console.log(err);
      }
    });
  }

  gerenciar(livroId: number): void {
    this.router.navigate(['/admin/livros/gerenciar', livroId]);
  }

}
