import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

  form: FormGroup;

  errorMessages = {
    'required': "Esse campo é obrigatório",
    'pattern': "Formato inválido"
  };

  constructor() { }

  ngOnInit(): void {
    this.form = new FormGroup({
      nome: new FormControl("", Validators.required),
      sobrenome: new FormControl("", Validators.required),
      cpf: new FormControl("", [
        Validators.required,
        Validators.pattern(/\d{3}.\d{3}.\d{3}-\d{2}/)
      ]),
      username: new FormControl("", Validators.required),
      tipoUsuario: new FormControl(""),
      email: new FormControl("", Validators.required),
      senha: new FormControl("", Validators.required),
      confirmarSenha: new FormControl("", Validators.required),
      dataNascimento: new FormControl("", Validators.required),
      rua: new FormControl("", Validators.required),
      numero: new FormControl("", Validators.required),
      bairro: new FormControl("", Validators.required),
      cep: new FormControl("", [
        Validators.required,
        Validators.pattern(/\d{5}-\d{3}/)
      ]),
      complemento: new FormControl("")
    });
  }

  cadastrar(): void {
    // Marca todos os input fields como mudado,
    // assim eles podem mostrar erros de validações
    this.form.markAllAsTouched();

    if (this.form.valid) {
      console.log("Tudo ok!");
    }
  }
}
