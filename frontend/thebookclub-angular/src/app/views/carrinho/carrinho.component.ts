import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pedido } from 'src/app/modelos/Pedido';
import { PedidoLivro } from 'src/app/modelos/PedidoLivro';
import { AlertasService } from 'src/app/service/alertas.service';
import { CarrinhoService } from 'src/app/service/carrinho.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  listaPedidoLivro: PedidoLivro[] = [];
  metodoPagamento: string = "";
  formaEnvio: string = "";

  constructor(
    private usuarioService: UsuarioService,
    private carrinhoService: CarrinhoService,
    private alertaService: AlertasService,
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
      this.alertaService.showAlertInfo('Entre com sua conta para poder finalizar o pedido');
      this.router.navigate(['/entrar']);
    } else {
      this.carrinhoService.checkoutCarrinho(this.metodoPagamento, this.formaEnvio).subscribe(
        (pedido: Pedido) => {
          this.carrinhoService.resetar();
          this.listaPedidoLivro = [];
          this.alertaService.showAlertSucess('Pedido finalizado! Muito obrigado por usar o nosso site!');
          this.router.navigate(['/inicio']);
        })
    }
  }
}

