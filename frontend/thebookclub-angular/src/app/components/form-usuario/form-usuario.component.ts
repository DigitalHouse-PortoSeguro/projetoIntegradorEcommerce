import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Usuario } from 'src/app/modelos/Usuario';
import { LocalDate } from 'src/app/utils/LocalDate';
import CustomValidators from '../validators/CustomValidators';

@Component({
	selector: 'app-form-usuario',
	templateUrl: './form-usuario.component.html',
	styleUrls: ['./form-usuario.component.css']
})
export class FormUsuarioComponent implements OnInit {

	form: FormGroup;
	@Input() usuario: Usuario = new Usuario();
	@Input() incluirTipo: boolean = false;
	@Input() submitText: string;
	@Output() onSubmit: EventEmitter<Usuario> = new EventEmitter(); 

	constructor(
		private formBuilder: FormBuilder
	) { }

	ngOnInit(): void {
		this.form = this.formBuilder.group({
			nome: [this.usuario.nome ?? "", [
				CustomValidators.required("O nome é obrigatório")
			]],
			sobrenome: [this.usuario.sobrenome ?? "", [
				CustomValidators.required("O sobrenome é obrigatório")
			]],
			cpf: [this.usuario.cpf ?? "", [
				CustomValidators.required("O CPF é obrigatório"),
				CustomValidators.pattern(/^\d{3}.\d{3}.\d{3}-\d{2}$/, "O CPF deve seguir o formato 000.000.000-00")
			]],
			username: [this.usuario.username ?? "", [
				CustomValidators.required("O username é obrigatório"),
				CustomValidators.minLength(5, "O username deve ter no mínimo 5 caracteres")
			]],
			email: [this.usuario.email ?? "", [
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
			dataNascimento: [this.usuario.dataNascimento?.toString() ?? "", [
				CustomValidators.required("A data de nascimento é obrigatória"),
			]],
			rua: [this.usuario.rua?? "", [
				CustomValidators.required("A rua é obrigatória"),
			]],
			numero: [this.usuario.numero ?? 0, [
				CustomValidators.required("O número é obrigatório"),
			]],
			bairro: [this.usuario.bairro ?? "", [
				CustomValidators.required("O bairro é obrigatório"),
			]],
			cep: [this.usuario.cep ?? "", [
				CustomValidators.required("O CEP é obrigatório"),
				CustomValidators.pattern(/^\d{5}-\d{3}$/, "O CEP deve seguir o formato XXXXX-XX")
			]],
			complemento: [this.usuario.complemento ?? ""],
		});

		if (this.incluirTipo) {
			this.form.addControl(
				"tipoUsuario",
				this.formBuilder.control("", [
					CustomValidators.required("O tipo de usuário é obrigatório")
				])
			);
		}
	}

	submit(): void {
		// Marca todos os input fields como mudado,
		// assim eles podem mostrar erros de validações
		this.form.markAllAsTouched();

		if (this.form.valid) {
			this.usuario.nome = this.form.get('nome')?.value;
			this.usuario.sobrenome = this.form.get('sobrenome')?.value;
			this.usuario.cpf = this.form.get('cpf')?.value;
			this.usuario.username = this.form.get('username')?.value;
			this.usuario.email = this.form.get('email')?.value;
			this.usuario.senha = this.form.get('senha')?.value;
			this.usuario.dataNascimento = LocalDate.fromString(this.form.get('dataNascimento')?.value);
			this.usuario.rua = this.form.get('rua')?.value;
			this.usuario.numero = Number.parseInt(this.form.get('numero')?.value);
			this.usuario.bairro = this.form.get('bairro')?.value;
			this.usuario.cep = this.form.get('cep')?.value;
			this.usuario.complemento = this.form.get('complemento')?.value;

			if (this.incluirTipo && this.form.get('tipoUsuario')?.value === "ADMIN") {
				this.usuario.tipoUsuario = "ADMIN";
			} else {
				this.usuario.tipoUsuario = "COMUM";
			}

			this.onSubmit.emit(this.usuario);
		}
	}
}
