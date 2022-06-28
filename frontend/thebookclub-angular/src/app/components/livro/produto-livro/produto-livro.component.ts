import { Component, Input, OnInit } from '@angular/core';
import { Livro } from 'src/app/modelos/Livro';
import { PedidoLivro } from 'src/app/modelos/PedidoLivro';
import { CarrinhoService } from 'src/app/service/carrinho.service';

@Component({
  selector: 'app-produto-livro',
  templateUrl: './produto-livro.component.html',
  styleUrls: ['./produto-livro.component.css']
})
export class ProdutoLivroComponent implements OnInit {

  @Input() livro: Livro;

  quantidadeOptions: string[];
  quantidade: number = 0;

  constructor(
    private carrinho: CarrinhoService
  ) { }

  ngOnInit(): void {
    this.quantidadeOptions = [];
    for (let i = 0; i < 4 && i < this.livro.quantidadeEstoque; i++) {
      this.quantidadeOptions.push((i + 1).toString());
    }
  }

  adicionar(): void {
    const pedidoLivro = new PedidoLivro();
    pedidoLivro.livro = this.livro;
    pedidoLivro.precoVenda = this.livro.preco;
    pedidoLivro.quantidade = this.quantidade;

    this.carrinho.adicionarPedidoLivro(pedidoLivro);
  }

}
