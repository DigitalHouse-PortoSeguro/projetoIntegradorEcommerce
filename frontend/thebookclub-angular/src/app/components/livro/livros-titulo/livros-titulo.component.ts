import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from 'src/app/modelos/Livro';
import { AlertasService } from 'src/app/service/alertas.service';
import { LivroService } from 'src/app/service/livro.service';

@Component({
  selector: 'app-livros-titulo',
  templateUrl: './livros-titulo.component.html',
  styleUrls: ['./livros-titulo.component.css']
})
export class LivrosTituloComponent implements OnInit {

  titulo: string = "";
  livros: Livro[] = [];

  constructor(
    private livroService: LivroService,
    private alertaService: AlertasService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.titulo = params.get('titulo')!!;

      this.livroService.getAllLivrosByTitulo(this.titulo).subscribe({
        next: livros => {
          this.livros = livros;
        },
        error: err => {
          console.log(err);
          this.alertaService.showAlertDanger('Um erro aconteceu');
        }
      })
    })
  }

  onLivroSelect(id: number): void {
    console.log(id);
    this.router.navigate(['/livros/produto', id]);
  }

}
