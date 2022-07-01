import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Usuario } from 'src/app/modelos/Usuario';
import { AlertasService } from 'src/app/service/alertas.service';
import { ConsultaCepService } from 'src/app/service/consulta-cep.service';
import { LocalDate } from 'src/app/utils/LocalDate';
import CustomValidators from '../../validators/CustomValidators';

@Component({
	selector: 'app-form-usuario',
	templateUrl: './form-usuario.component.html',
	styleUrls: ['./form-usuario.component.css']
})
export class FormUsuarioComponent implements OnInit {

	form: FormGroup;
	buscandoEndereco: boolean;

	@Input() usuario: Usuario = new Usuario();
	@Input() incluirTipo: boolean = false;
	@Input() submitText: string;
	@Output() onSubmit: EventEmitter<Usuario> = new EventEmitter(); 

	constructor(
		private formBuilder: FormBuilder,
		private cepService: ConsultaCepService,
		private alertaService: AlertasService
	) { }

	ngOnInit(): void {
		this.buscandoEndereco = false;

		this.form = this.formBuilder.group({
			nome: [this.usuario?.nome ?? "", [
				CustomValidators.required("O nome é obrigatório")
			]],
			sobrenome: [this.usuario?.sobrenome ?? "", [
				CustomValidators.required("O sobrenome é obrigatório")
			]],
			cpf: [this.usuario?.cpf ?? "", [
				CustomValidators.required("O CPF é obrigatório"),
				CustomValidators.pattern(/^\d{3}.\d{3}.\d{3}-\d{2}$/, "O CPF deve seguir o formato 000.000.000-00")
			]],
			username: [this.usuario?.username ?? "", [
				CustomValidators.required("O username é obrigatório"),
				CustomValidators.minLength(5, "O username deve ter no mínimo 5 caracteres")
			]],
			email: [this.usuario?.email ?? "", [
				CustomValidators.required("O email é obrigatório"),
				CustomValidators.pattern(/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/,
				"O email deve seguir o formato exemplo@email.com")
			]],
			senha: ["", [
				CustomValidators.required("A senha é obrigatória"),
				CustomValidators.minLength(6, "A senha deve ter no mínimo 6 caracteres")
			]],
			confirmarSenha: ["", [
				CustomValidators.required("A confirmação da senha é obrigatória"),
				CustomValidators.matchField("senha", "As senhas são diferentes")
			]],
			foto: [this.usuario?.foto ?? "", []],
			dataNascimento: [this.usuario?.dataNascimento?.toString() ?? "", [
				CustomValidators.required("A data de nascimento é obrigatória"),
			]],
			rua: [this.usuario?.rua ?? "", [
				CustomValidators.required("A rua é obrigatória"),
			]],
			numero: [this.usuario?.numero ?? "", [
				CustomValidators.required("O número é obrigatório"),
			]],
			bairro: [this.usuario?.bairro ?? "", [
				CustomValidators.required("O bairro é obrigatório"),
			]],
			cep: [this.usuario?.cep ?? "", [
				CustomValidators.required("O CEP é obrigatório"),
				CustomValidators.pattern(/^\d{5}-?\d{3}$/, "O CEP deve seguir o formato XXXXX-XX")
			]],
			complemento: [this.usuario?.complemento ?? ""],
		});

		if (this.incluirTipo) {
			this.form.addControl(
				"tipoUsuario",
				this.formBuilder.control(this.usuario.tipoUsuario ?? "", [
					CustomValidators.required("O tipo de usuário é obrigatório")
				])
			);
		}
	}

	submit(): void {
		// Marca todos os input fields como mudado,
		// assim eles podem mostrar erros de validações
		this.form.markAllAsTouched();

		// Alguns campos estão carregando
		if (this.buscandoEndereco) return;
		if(!this.form.valid) {
			this.alertaService.showAlertDanger('Formulário está Incompleto');
			return;
		}

		if (this.form.valid) {
			this.usuario.nome = this.form.get('nome')!.value;
			this.usuario.sobrenome = this.form.get('sobrenome')!.value;
			this.usuario.cpf = this.form.get('cpf')?.value;
			this.usuario.username = this.form.get('username')!.value;
			this.usuario.email = this.form.get('email')!.value;
			this.usuario.senha = this.form.get('senha')!.value;
			this.usuario.foto = this.form.get('foto')?.value;
			this.usuario.dataNascimento = LocalDate.fromString(this.form.get('dataNascimento')!.value);
			this.usuario.rua = this.form.get('rua')!.value;
			this.usuario.numero = Number.parseInt(this.form.get('numero')!.value);
			this.usuario.bairro = this.form.get('bairro')!.value;
			this.usuario.cep = this.form.get('cep')!.value;
			this.usuario.complemento = this.form.get('complemento')?.value;

			if (this.incluirTipo && this.form.get('tipoUsuario')?.value === "ADMIN") {
				this.usuario.tipoUsuario = "ADMIN";
			} else {
				this.usuario.tipoUsuario = "COMUM";
			}

			this.onSubmit.emit(this.usuario);
		}
	}

	//-------------- MÉTODOS PARA CONSULTA CEP -------------
	buscarCEP() {
		this.desabilitarEndereco();
		
		this.cepService.consultaCEP(this.form.get('cep')?.value).subscribe({
			next: resp => {
				this.habilitarEndereco();
				this.form.patchValue({
					"cep": resp.cep,
					"rua": resp.logradouro,
					"bairro": resp.bairro,
					//"complemento": resp.complemento,
				});
			},
			error: err => {
				this.alertaService.showAlertDanger('Um erro aconteceu');
				console.log(err);
				this.habilitarEndereco();
			}
		})
	}

	desabilitarEndereco() {
		this.buscandoEndereco = true;
		this.form.get('cep')?.disable();
		this.form.get('rua')?.disable();
		this.form.get('bairro')?.disable();
		this.form.get('complemento')?.disable();
	}

	habilitarEndereco() {
		this.buscandoEndereco = false;
		this.form.get('cep')?.enable();
		this.form.get('rua')?.enable();
		this.form.get('bairro')?.enable();
		this.form.get('complemento')?.enable();
	}
}
