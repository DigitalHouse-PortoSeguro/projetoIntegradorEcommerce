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

  constructor() { 
  }
}
