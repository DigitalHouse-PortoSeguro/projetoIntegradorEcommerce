import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pedido } from 'src/app/modelos/Pedido';
import { PedidoLivro } from 'src/app/modelos/PedidoLivro';
import { CarrinhoService } from 'src/app/service/carrinho.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  listaPedidoLivro: PedidoLivro[] = []

  constructor(
    private usuarioService: UsuarioService,
    private carrinhoService: CarrinhoService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.listaPedidoLivro = this.carrinhoService.getAllPedidoLivros()
  }

  getTotal(): Number {
    return this.carrinhoService.getTotal()
  }

  finalizarPedido() {
    if (!this.usuarioService.isLoggedIn()) {
      this.router.navigate(['/entrar']);
    } else {
      this.carrinhoService.checkoutCarrinho('DEBITO', 'CORREIOS').subscribe(
        (pedido: Pedido) => {
          this.carrinhoService.resetar();
          this.listaPedidoLivro = [];
          alert('O pedido foi finalizado');
        })
    }
  }
}

