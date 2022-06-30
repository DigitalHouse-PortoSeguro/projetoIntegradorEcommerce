import { Component, OnInit } from '@angular/core';
import { LivroService } from 'src/app/service/livro.service';

@Component({
  selector: 'app-categorias-geral',
  templateUrl: './categorias-geral.component.html',
  styleUrls: ['./categorias-geral.component.css']
})
export class CategoriasGeralComponent implements OnInit {

  listaCategorias: String[] = [];

  constructor(private categoriaService: LivroService) { }

  ngOnInit(){
    this.categoriaService.getAllCategorias().subscribe(
      (resp: String[]) => {
        this.listaCategorias = resp;
      })
  }
}
