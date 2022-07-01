import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from 'src/app/modelos/Livro';
import { AlertasService } from 'src/app/service/alertas.service';
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
    private alertaService: AlertasService,
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
      this.livroService.getLivroById(id).subscribe({
        next: resp => {
          this.livro = resp;
          console.log(resp);
        },
        error: err => {
          this.alertaService.showAlertDanger('Um erro aconteceu');
          console.log(err);
        }
      });
    });
  }

  atualizarLivro(): void {
    this.router.navigate(['/admin/livros/atualizar', this.livro.livroId]);
  }

  deletarLivro(): void {
    this.livroService.deletarLivro(this.livro.livroId).subscribe({
      next: resp => {
        this.alertaService.showAlertSucess('Livro deletado com sucesso!');
        this.router.navigate(['/admin/livros/lista']);
      },
      error: err => {
        this.alertaService.showAlertDanger('Um erro aconteceu');
        console.log(err);
      }
    })
  }
  voltarListagem() {
    this.router.navigate(['/admin/livros/lista']);
      return;
  }


}
