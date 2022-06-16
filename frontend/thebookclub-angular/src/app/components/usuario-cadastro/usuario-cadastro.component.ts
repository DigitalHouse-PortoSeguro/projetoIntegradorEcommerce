import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioLogin } from 'src/app/modelos/UsuarioLogin';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

  form: FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.form = new FormGroup({
      nome: new FormControl(""),
      sobrenome: new FormControl(""),
      cpf: new FormControl(""),
      username: new FormControl(""),
      tipoUsuario: new FormControl(""),
      email: new FormControl(""),
      senha: new FormControl(""),
      confirmarSenha: new FormControl(""),
      dataNascimento: new FormControl(""),
      rua: new FormControl(""),
      numero: new FormControl(""),
      bairro: new FormControl(""),
      cep: new FormControl(""),
      complemento: new FormControl("")
    });
  }

  cadastrar(): void {
    console.log(this.form.value)
  }
}
