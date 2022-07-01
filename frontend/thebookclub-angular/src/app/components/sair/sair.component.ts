import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarrinhoService } from 'src/app/service/carrinho.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-sair',
  templateUrl: './sair.component.html',
  styleUrls: ['./sair.component.css']
})
export class SairComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService,
    private carrinhoService: CarrinhoService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.usuarioService.logout();
    this.carrinhoService.resetar();
    this.router.navigate(['/entrar']);
  }

}
