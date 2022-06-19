import { Component } from '@angular/core';
import { Livro } from './modelos/Livro';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'thebookclub-angular';

  livros: Livro[];

  private createLivro(
    titulo: string,
    foto: string,
    autores: string,
    preco: number
  ): Livro {
    const l = new Livro();

    l.titulo = titulo;
    l.foto = foto;
    l.autores = autores;
    l.preco = preco;

    return l;
  }

  constructor() { 
    const livros = [
      this.createLivro(
        "Os segredos da mente milionária",
        "https://images-na.ssl-images-amazon.com/images/I/81ZnJcgjCdL.jpg",
        "T. Harv Eker",
        30.9
      ),
      this.createLivro(
        "As Crônicas de Nárnia",
        "https://images-na.ssl-images-amazon.com/images/I/71yJLhQekBL.jpg",
        "C. S. Lewis",
        89.9
      ),
      this.createLivro(
        "Star Wars: Marcas da Guerra",
        "https://images-na.ssl-images-amazon.com/images/I/91wNLQh9oPL.jpg",
        "Chuck Wendig",
        33.9
      ),
      this.createLivro(
        "Harry Potter e o Prisioneiro de Azkaban",
        "https://images-na.ssl-images-amazon.com/images/I/81u+ljPVifL.jpg",
        "J.K. Rowling",
        35.9
      ),
    ];

    this.livros = [];

    for (let i = 0; i < 32; i++) {
      this.livros.push(livros[i % livros.length]);
    }
  }
}
