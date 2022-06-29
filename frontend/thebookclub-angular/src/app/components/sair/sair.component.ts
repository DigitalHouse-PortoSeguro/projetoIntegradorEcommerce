import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-sair',
  templateUrl: './sair.component.html',
  styleUrls: ['./sair.component.css']
})
export class SairComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.usuarioService.logout();
    this.router.navigate(['entrar']);
  }

}
