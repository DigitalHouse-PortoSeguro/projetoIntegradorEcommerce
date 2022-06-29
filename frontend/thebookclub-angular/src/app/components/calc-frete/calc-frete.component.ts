import { Component, Input, OnInit } from '@angular/core';
import { PedidoLivro } from 'src/app/modelos/PedidoLivro';

@Component({
  selector: 'app-calc-frete',
  templateUrl: './calc-frete.component.html',
  styleUrls: ['./calc-frete.component.css']
})
export class CalcFreteComponent implements OnInit {

  @Input()
  pedidoLivro = new PedidoLivro()

  constructor() { }

  ngOnInit(): void {
  }

}
