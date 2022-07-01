import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/modelos/Pedido';
import { PedidoLivro } from 'src/app/modelos/PedidoLivro';
import { AlertasService } from 'src/app/service/alertas.service';
import { CarrinhoService } from 'src/app/service/carrinho.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  listaPedidoLivro: PedidoLivro[] = []

  constructor(
    private carrinhoService: CarrinhoService,
    private alertaService: AlertasService
  ) { }

  ngOnInit(): void {
    this.listaPedidoLivro = this.carrinhoService.getAllPedidoLivros()
  }

  getTotal(): Number {
    return this.carrinhoService.getTotal()
  }

  finalizarPedido() {
    this.carrinhoService.checkoutCarrinho('DEBITO', 'CORREIOS').subscribe(
      (pedido: Pedido) => {
        this.carrinhoService.resetar();
        this.alertaService.showAlertSucess('Pedido finalizado!');
      })
  }
}

