import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from 'src/app/modelos/Livro';
import { LivroService } from 'src/app/service/livro.service';
import { UsuarioService } from 'src/app/service/usuario.service';
import { globals } from 'src/environments/environment.prod';

@Component({
  selector: 'app-gerenciar-livro',
  templateUrl: './gerenciar-livro.component.html',
  styleUrls: ['./gerenciar-livro.component.css']
})
export class GerenciarLivroComponent implements OnInit {

  livro: Livro;

  constructor(
    private usuarioService: UsuarioService,
    private livroService: LivroService,
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
      this.livroService.getLivroById(id).subscribe({
        next: resp => {
          this.livro = resp;
          console.log(resp);
        },
        error: err => {
          alert('Um erro aconteceu...');
          console.log(err);
        }
      });
    });
  }

  atualizarLivro(): void {
    this.router.navigate(['livro/atualizar-livro', this.livro.livroId]);
  }

  deletarLivro(): void {
    this.livroService.deletarLivro(this.livro.livroId).subscribe({
      next: resp => {
        alert('Livro deletado com sucesso!');
        this.router.navigate(['livros/listagem']);
      },
      error: err => {
        console.log(err);
        alert('Um erro aconteceu...');
      }
    })
  }
  voltarListagem() {
    this.router.navigate(['livros/listagem']);
      return;
  }


}
