import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Livro } from 'src/app/modelos/Livro';
import { PedidoLivro } from 'src/app/modelos/PedidoLivro';
import { CarrinhoService } from 'src/app/service/carrinho.service';
import { LivroService } from 'src/app/service/livro.service';

@Component({
  selector: 'app-produto-livro',
  templateUrl: './produto-livro.component.html',
  styleUrls: ['./produto-livro.component.css']
})
export class ProdutoLivroComponent implements OnInit {

  livro: Livro;

  quantidadeOptions: string[] = [];
  quantidade: number = 0;

  constructor(
    private livroService: LivroService,
    private carrinho: CarrinhoService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.livroService.getLivroById(Number(params.get('id'))).subscribe({
        next: livro => {
          this.livro = livro;
          this.quantidadeOptions = [];
          for (let i = 0; i < 4 && i < livro.quantidadeEstoque; i++) {
            this.quantidadeOptions.push((i + 1).toString());
          }
        },
        error: err => {
          console.log(err);
          alert("Um erro aconteceu");
        }
      })
    });
  }

  adicionar(): void {
    const pedidoLivro = new PedidoLivro();
    pedidoLivro.livro = this.livro;
    pedidoLivro.precoVenda = this.livro.preco;
    pedidoLivro.quantidade = this.quantidade;

    this.carrinho.adicionarPedidoLivro(pedidoLivro);
    this.carrinho.saveCarrinhoLocalStorage();
  }

}
