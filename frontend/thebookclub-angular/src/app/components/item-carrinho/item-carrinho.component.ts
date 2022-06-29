import { Component, Input, OnInit } from '@angular/core';
import { PedidoLivro } from 'src/app/modelos/PedidoLivro';

@Component({
  selector: 'app-item-carrinho',
  templateUrl: './item-carrinho.component.html',
  styleUrls: ['./item-carrinho.component.css']
})
export class ItemCarrinhoComponent implements OnInit {

  @Input()
  pedidoLivro = new PedidoLivro()

  constructor() { }

  ngOnInit(): void {
  }

}
