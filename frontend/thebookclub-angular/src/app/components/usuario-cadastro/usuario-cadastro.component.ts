import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgControl, Validators } from '@angular/forms';
import { Usuario } from 'src/app/modelos/Usuario';
import { UsuarioService } from 'src/app/service/usuario.service';
import { LocalDate } from 'src/app/utils/LocalDate';
import CustomValidators from '../validators/CustomValidators';

@Component({
	selector: 'app-usuario-cadastro',
	templateUrl: './usuario-cadastro.component.html',
	styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

	form: FormGroup;

	constructor(
		private formBuilder: FormBuilder,
		private http: HttpClient,
		private usuarioService: UsuarioService
	) { }

	ngOnInit(): void {
		this.form = this.formBuilder.group({
			nome: ['', [
				CustomValidators.required("O nome é obrigatório")
			]],
			sobrenome: ['', [
				CustomValidators.required("O sobrenome é obrigatório")
			]],
			cpf: ['', [
				CustomValidators.required("O CPF é obrigatório"),
				CustomValidators.pattern(/^\d{3}.\d{3}.\d{3}-\d{2}$/, "O CPF deve seguir o formato 000.000.000-00")
			]],
			username: ['', [
				CustomValidators.required("O username é obrigatório"),
				CustomValidators.minLength(5, "O username deve ter no mínimo 5 caracteres")
			]],
			tipoUsuario: ['', [
				CustomValidators.required("O tipo de usuário é obrigatório")
			]],
			email: ['', [
				CustomValidators.required("O email é obrigatório"),
				CustomValidators.email("O email deve seguir o formato exemplo@email.com")
			]],
			senha: ['', [
				CustomValidators.required("A senha é obrigatória"),
			]],
			confirmarSenha: ['', [
				CustomValidators.required("A confirmação da senha é obrigatória"),
				CustomValidators.matchField("senha", "As senhas são diferentes")
			]],
			dataNascimento: ['', [
				CustomValidators.required("A data de nascimento é obrigatória"),
			]],
			rua: ['', [
				CustomValidators.required("A rua é obrigatória"),
			]],
			numero: ['', [
				CustomValidators.required("O número é obrigatório"),
			]],
			bairro: ['', [
				CustomValidators.required("O bairro é obrigatório"),
			]],
			cep: ['', [
				CustomValidators.required("O CEP é obrigatório"),
				CustomValidators.pattern(/^\d{5}-\d{3}$/, "O CEP deve seguir o formato XXXXX-XX")
			]],
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
			usuario.dataNascimento = new LocalDate(this.form.get('dataNascimento')?.value);
			usuario.rua = this.form.get('rua')?.value;
			usuario.numero = Number.parseInt(this.form.get('numero')?.value);
			usuario.bairro = this.form.get('bairro')?.value;
			usuario.cep = this.form.get('cep')?.value;
			usuario.complemento = this.form.get('complemento')?.value;

			if (this.form.get('tipoUsuario')?.value == 'admin') {
				usuario.tipoUsuario = "ADMIN";
			} else {
				usuario.tipoUsuario = "COMUM";
			}

			//console.log(usuario);

			this.usuarioService.cadastrarUsuario(usuario).subscribe({
				next: resp => {
					console.log(resp);
					alert('Usuário cadastrado com sucesso!');
				},
				error: err => {
					console.log(err);
					alert('Um erro aconteceu...');
				}
			})

			/*//simulação do post
			this.http.post('https://httpbin.org/post', JSON.stringify(this.form.value))
				.subscribe((dados) => {
					console.log(dados);
					//reset do formulario
					this.form.reset();
				},
					(error: any) => alert("erro"));*/
		}
	}
}
