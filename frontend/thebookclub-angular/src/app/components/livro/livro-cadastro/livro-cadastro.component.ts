import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup} from '@angular/forms';
import { Livro } from 'src/app/modelos/Livro';
import { LivroService } from 'src/app/service/livro.service';
import { LocalDate } from 'src/app/utils/LocalDate';

@Component({
  selector: 'app-livro-cadastro',
  templateUrl: './livro-cadastro.component.html',
  styleUrls: ['./livro-cadastro.component.css']
})
export class LivroCadastroComponent implements OnInit {

  form : FormGroup

  constructor(private FormBuilder : FormBuilder,
              private LivroService : LivroService) { }

  ngOnInit(){
    this.form = this.FormBuilder.group({
      Titulo : ['', ],
      DataPublicacao : ['', ],
      Autores : ['', ],
      Editora : ['', ],
      Categoria : ['', ],
      NumeroDePaginas : ['', ],
      Preco : ['', ],
      ISBN : ['', ],
      QuantidadeNoEstoque : ['', ],
      Fornecedor : ['', ]
    })
  }

  enviar(){
    if(!this.form.valid){
      alert('Formulário está Incompleto!!!')
      return
    }
    console.log(this.form.get('DataPublicacao')!.value)
    let livro = new Livro()
    
    livro.titulo = this.form.get('Titulo')!.value
    livro.dataPublicacao = LocalDate.fromString(this.form.get('Titulo')!.value) 
    livro.autores = this.form.get('Autores')!.value
    livro.editora = this.form.get('Editora')!.value
    livro.categoria = this.form.get('Categoria')!.value
    livro.numeroPaginas = Number(this.form.get('NumeroDePaginas')!.value)
    livro.preco = Number(this.form.get('Preco')!.value)
    livro.isbn = this.form.get('ISBN')!.value
    livro.quantidadeEstoque = Number(this.form.get('QuantidadeNoEstoque')!.value)
    livro.fornecedor = this.form.get('Fornecedor')!.value

    this.LivroService.cadastrarLivro(livro).subscribe({
      next : LivroResposta => {alert('Livro Cadastrado!!!')},
      error : Erro => {alert('Erro ao Cadastrar o Livro!!!')
              console.log(Erro)  
    }
    })
  }
  


}
