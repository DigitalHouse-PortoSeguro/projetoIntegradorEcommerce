import { Component } from '@angular/core';
import { globals } from 'src/environments/environment.prod';
import { Livro } from './modelos/Livro';
import { Pedido } from './modelos/Pedido';
import { PedidoLivro } from './modelos/PedidoLivro';
import { UsuarioLogin } from './modelos/UsuarioLogin';
import { CarrinhoService } from './service/carrinho.service';
import { LocalDate, LocalDateTime } from './utils/LocalDate';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'thebookclub-angular';

  constructor(
    private carrinhoService: CarrinhoService
  ) { 
    globals.usuarioLogin = new UsuarioLogin();
    globals.usuarioLogin.token = btoa("ghsoares:Senha123");
    globals.usuarioLogin.usuarioId = 1;
    carrinhoService.resetar();
  }

  addLivro(): void {
    const livro = new Livro();

    livro.livroId = 1;
    livro.titulo = "Livro 1";
    livro.dataPublicacao = new LocalDate("1990-03-11");
    livro.autores = "Autor 1";
    livro.categoria = "Ação e Aventura";
    livro.numeroPaginas = 37;
    livro.isbn = "0000000001";
    livro.preco = 57.0;
    livro.quantidadeEstoque = 100;
    livro.fornecedor = "fornecedor 1";

    const pedidoLivro = new PedidoLivro();
    pedidoLivro.livro = livro;
    pedidoLivro.precoVenda = livro.preco;
    pedidoLivro.quantidade = 1;
    
    this.carrinhoService.adicionarPedidoLivro(pedidoLivro);
  }

  checkout(): void {
    

    this.carrinhoService.checkoutCarrinho("DEBITO", "CORREIOS").subscribe(
      {
        next: (resp) => {
          console.log(resp);
          alert('Carrinho checkout com sucesso');
        },
        error: (err) => {
          console.log(err);
          alert('Um erro aconteceu...');
        }
      }
    );
  }

  getLivros(): PedidoLivro[] {
    return this.carrinhoService.getAllPedidoLivros();
  }

  getTotal(): number {
    return this.carrinhoService.getTotal();
  }
}
