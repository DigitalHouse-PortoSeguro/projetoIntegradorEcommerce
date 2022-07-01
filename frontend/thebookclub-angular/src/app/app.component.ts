import { Component, OnInit } from '@angular/core';
import { globals } from 'src/environments/environment';
import { Livro } from './modelos/Livro';
import { UsuarioLogin } from './modelos/UsuarioLogin';
import { AlertasService } from './service/alertas.service';
import { CarrinhoService } from './service/carrinho.service';
import { UsuarioService } from './service/usuario.service';
import { LocalDate } from './utils/LocalDate';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'thebookclub-angular';

  livro: Livro;
  livro2: Livro;

  private createLivro(
    titulo: string,
    foto: string,
    autores: string,
    data: string,
    quantidade: number,
    paginas: number,
    editora: string,
    categoria: string,
    sinopse: string,
    isbn: string,
    preco: number
  ): Livro {
    const l = new Livro();

    l.titulo = titulo;
    l.foto = foto;
    l.autores = autores;
    l.dataPublicacao = LocalDate.fromString(data);
    l.quantidadeEstoque = quantidade;
    l.numeroPaginas = paginas;
    l.editora = editora;
    l.categoria = categoria;
    l.sinopse = sinopse;
    l.isbn = isbn;
    l.preco = preco;

    return l;
  }

  constructor(
    private carrinhoService: CarrinhoService,
    private usuarioService: UsuarioService,
    private alertasServices: AlertasService
  ) {
    this.livro = this.createLivro(
      "Os segredos da mente milionária",
      "https://images-na.ssl-images-amazon.com/images/I/81ZnJcgjCdL.jpg",
      "T. Harv Eker",
      "2005-08-13",
      10,
      30,
      "Editora",
      "Auto ajuda",
      "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Aperiam culpa expedita assumenda debitis earum rerum totam minus aliquam possimus, iure iste reiciendis nulla excepturi ratione praesentium quam officiis iusto quo!",
      "100011",
      30.9
    );
    this.livro2 = this.createLivro(
      "Livro Aventura 01",
      "https://images-na.ssl-images-amazon.com/images/I/81ZnJcgjCdL.jpg",
      "Teste ",
      "2005-08-13",
      10,
      30,
      "Editora Teste",
      "Aventura",
      "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Aperiam culpa expedita assumenda debitis earum rerum totam minus aliquam possimus, iure iste reiciendis nulla excepturi ratione praesentium quam officiis iusto quo!",
      "100011",
      30.9
    );

    const user = new UsuarioLogin();

    user.bairro = "Jaraguá"
    user.cep = "05182-000"
    user.complemento = ""
    user.cpf = "131.131.131-03"
    user.dataNascimento = LocalDate.fromString("2002-11-25")
    user.email = "ghsoares99795@gmail.com"
    user.nome = "Gabriel Henrique"
    user.numero = 100
    user.preferencias = "";
    user.rua = "Mauro D' Araújo Ribeiro"
    user.senha = "$2a$10$s5WHHaUrkJeWfC7.n2o3XuvHlKytNOm0VcNp/uQg1uzZ.NSgba/yG"
    user.sobrenome = "Pereira Soares"
    user.tipoUsuario = "ADMIN"
    user.username = "ruitemgi"
    user.usuarioId = 1
    user.token = "Basic " + btoa("root:root")

    
    //globals.usuarioLogin = user
  }

  ngOnInit(): void {
    // this.alertasServices.showAlertInfo('Teste com Alert de Erro');
    this.usuarioService.loadUsuarioLocalStorage();
    this.carrinhoService.loadCarrinhoLocalStorage();

    /*
    teste dos livros para o carrinho
    var livro = this.createLivro('livro1', 'https://images-na.ssl-images-amazon.com/images/I/81ZnJcgjCdL.jpg', 'fulano det al', '2000-10-22', 100, 20, 'moderna', 'Auto-ajuda', 'oaksdmejncuhucd', 'aduedecnj', 30.90)

    var pedidoLivro = new PedidoLivro()

    pedidoLivro.livro = livro
    pedidoLivro.quantidade = 4
    pedidoLivro.precoVenda = livro.preco

    this.carrinhoService.adicionarPedidoLivro(pedidoLivro)
    this.carrinhoService.adicionarPedidoLivro(pedidoLivro)
    this.carrinhoService.adicionarPedidoLivro(pedidoLivro)
    this.carrinhoService.adicionarPedidoLivro(pedidoLivro)
    this.carrinhoService.adicionarPedidoLivro(pedidoLivro)
    */
  }
}
