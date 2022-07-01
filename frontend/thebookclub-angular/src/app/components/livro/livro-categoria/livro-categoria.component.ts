import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from 'src/app/modelos/Livro';
import { AlertasService } from 'src/app/service/alertas.service';
import { LivroService } from 'src/app/service/livro.service';

@Component({
  selector: 'app-livro-categoria',
  templateUrl: './livro-categoria.component.html',
  styleUrls: ['./livro-categoria.component.css']
})
export class LivroCategoriaComponent implements OnInit {

  listaLivrosCategoria: Livro[];

  constructor(
    private livroService: LivroService,
    private router: Router,
    private alertaService: AlertasService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.findByCategoria(params.get('categoria')!!);
    })
  }

  findByCategoria(categoria:string) {
    this.livroService.getAllLivrosByCategoria(categoria).subscribe({
      next: (resp: Livro[]) => {
        console.log(resp);
        
        this.listaLivrosCategoria = resp;
      },
      error: err => {
        console.log(err);
        this.alertaService.showAlertDanger('Um erro aconteceu');
      }
    })
  }

  onLivroSelect(id: number): void {
    console.log(id);
    this.router.navigate(['/livros/produto', id]);
  }



}
