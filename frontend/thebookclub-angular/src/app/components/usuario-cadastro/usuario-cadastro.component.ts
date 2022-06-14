import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

  usuario: Usuario;
  usuarioLogin: UsuarioLogin;

  constructor() { }

  ngOnInit(): void {
  }

}
