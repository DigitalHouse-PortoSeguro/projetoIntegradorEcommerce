import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgControl, Validators } from '@angular/forms';
import { Usuario } from 'src/app/modelos/Usuario';

@Component({
	selector: 'app-usuario-cadastro',
	templateUrl: './usuario-cadastro.component.html',
	styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

	form: FormGroup;

	constructor(
		private formBuilder: FormBuilder
	) { }

	ngOnInit(): void {
		this.form = this.formBuilder.group({
			nome: ['', [Validators.required]],
			sobrenome: ['', [Validators.required]],
			cpf: ['', [Validators.required, Validators.pattern(/^\d{3}.\d{3}.\d{3}-\d{2}$/)]],
			username: ['', [Validators.required]],
			tipoUsuario: [''],
			email: ['', [Validators.required, Validators.email]],
			senha: ['', [Validators.required]],
			confirmarSenha: ['', [Validators.required]],
			dataNascimento: ['', [Validators.required]],
			rua: ['', [Validators.required]],
			numero: ['', [Validators.required]],
			bairro: ['', [Validators.required]],
			cep: ['', [Validators.required, Validators.pattern(/^\d{5}-\d{3}$/)]],
			complemento: [''],
		});
	}

	cadastrar(): void {
		// Marca todos os input fields como mudado,
		// assim eles podem mostrar erros de validações
		this.form.markAllAsTouched();

		if (this.form.valid) {
			const usuario = new Usuario();

			usuario.nome = this.form.get('nome')?.value;
			usuario.sobrenome = this.form.get('sobrenome')?.value;
			usuario.cpf = this.form.get('cpf')?.value;
			usuario.username = this.form.get('username')?.value;
			usuario.email = this.form.get('email')?.value;
			usuario.senha = this.form.get('senha')?.value;
			usuario.dataNascimento = new Date(this.form.get('dataNascimento')?.value);
			usuario.rua = this.form.get('rua')?.value;
			usuario.numero = Number.parseInt(this.form.get('numero')?.value);
			usuario.bairro = this.form.get('bairro')?.value;
			usuario.cep = this.form.get('cep')?.value;
			usuario.complemento = this.form.get('complemento')?.value;
			
			console.log(usuario);
		}
	}
}
