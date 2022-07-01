import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';
import { FormBuilder, FormGroup} from '@angular/forms';
import { Livro } from 'src/app/modelos/Livro';
import { LivroService } from 'src/app/service/livro.service';
import { LocalDate } from 'src/app/utils/LocalDate';
import CustomValidators from '../../validators/CustomValidators';
import { AlertasService } from 'src/app/service/alertas.service';

@Component({
  selector: 'app-livro-cadastro',
  templateUrl: './livro-cadastro.component.html',
  styleUrls: ['./livro-cadastro.component.css']
})
export class LivroCadastroComponent implements OnInit {

  form : FormGroup

  constructor(private usuarioService: UsuarioService,
              private alertaService: AlertasService,
              private router: Router,
              private FormBuilder: FormBuilder,
              private LivroService : LivroService,
              private alertas: AlertasService
              ){ }

  ngOnInit() {
    if (!this.usuarioService.isLoggedIn()) {
      this.router.navigate(['/entrar']);
      return;
    }
    if (this.usuarioService.isLoggedIn() && !this.usuarioService.isAdmin()) {
      this.router.navigate(['/inicio']);
      return;
    }

    this.form = this.FormBuilder.group({
      Titulo : ['', [CustomValidators.required('O Título é Obrigatório'), CustomValidators.size(2, 100, 'O Tamanho do Título deve ser entre 2 e 100')]],
      DataPublicacao : ['', [CustomValidators.required('O DataPublicação é Obrigatório')]],
      Autores : ['', [CustomValidators.required('Os Autores são Obrigatório'), CustomValidators.size(2, 200, 'O Tamanho do Autores deve ser entre 2 e 200')]],
      Editora : ['', [CustomValidators.required('A Editora é Obrigatória'), CustomValidators.size(2, 30, 'O Tamanho da Editora deve ser entre 2 e 30')]],
      Categoria : ['', [CustomValidators.required('A Categoria é Obrigatória'), CustomValidators.size(2, 30, 'O Tamanho da Categoria deve ser entre 2 e 30')]],
      NumeroDePaginas : ['', [CustomValidators.required('O Número de Páginas é Obrigatório')]],
      Preco : ['', [CustomValidators.required('O Preço é Obrigatório')]],
      ISBN : ['', [CustomValidators.required('O ISBN é Obrigatório'), CustomValidators.size(8, 13, 'O Tamanho do ISBN deve ser entre 8 e 13')]],
      QuantidadeNoEstoque : ['', [CustomValidators.required('A Quantidade no Estoque é Obrigatório')]],
      Fornecedor : ['', [CustomValidators.required('O Fornecedor é Obrigatório'), CustomValidators.size(2, 100, 'O Tamanho do Fornecedor deve ser entre 2 e 100')]],
      Foto : ['', ],
      Sinopse : ['', [CustomValidators.required('A Sinopse é Obrigatória'), CustomValidators.size(2, 2048, 'O Tamanho da Sinopse deve ser entre 2 e 2048')]]
    })
  }

  enviar(){
    this.form.markAllAsTouched()
    if (!this.form.valid) {
      this.alertaService.showAlertDanger('Formulário está Incompleto');
      return
    }
    console.log(this.form.get('DataPublicacao')!.value)
    let livro = new Livro()
    
    livro.titulo = this.form.get('Titulo')!.value
    livro.dataPublicacao = LocalDate.fromString(this.form.get('DataPublicacao')!.value) 
    livro.autores = this.form.get('Autores')!.value
    livro.editora = this.form.get('Editora')!.value
    livro.categoria = this.form.get('Categoria')!.value
    livro.numeroPaginas = Number(this.form.get('NumeroDePaginas')!.value)
    livro.preco = Number(this.form.get('Preco')!.value)
    livro.isbn = this.form.get('ISBN')!.value
    livro.quantidadeEstoque = Number(this.form.get('QuantidadeNoEstoque')!.value)
    livro.fornecedor = this.form.get('Fornecedor')!.value
    livro.foto = this.form.get('Foto')!.value
    livro.sinopse = this.form.get('Sinopse')!.value

    this.LivroService.cadastrarLivro(livro).subscribe({
      next : LivroResposta => {this.alertaService.showAlertSucess('Livro cadastrado com sucesso');},
      error : Erro => {this.alertas.showAlertDanger('Erro ao Cadastrar o Livro!!!')
              console.log(Erro)  
    }
    })
  }
  


}
