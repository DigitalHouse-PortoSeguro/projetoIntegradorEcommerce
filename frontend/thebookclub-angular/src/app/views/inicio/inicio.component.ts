import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Livro } from 'src/app/modelos/Livro';
import { AlertasService } from 'src/app/service/alertas.service';
import { LivroService } from 'src/app/service/livro.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  listaLivros: Livro[];

  constructor(
    private livroService: LivroService,
    private alertaService: AlertasService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.livroService.getAllLivros().subscribe({
      next: livros => {
        for (let i = livros.length - 1; i > 0; i--) {
          let j = Math.floor(Math.random() * livros.length);

          let temp = livros[j];
          livros[j] = livros[i];
          livros[i] = temp;
        }
        this.listaLivros = livros.slice(0, 10);
      },
      error: err => {
        this.alertaService.showAlertDanger("Um erro aconteceu");
        console.log(err);
      }
    })
  }

  onLivroSelect(id: number): void {
    console.log(id);
    this.router.navigate(['/livros/produto', id]);
  }

}
