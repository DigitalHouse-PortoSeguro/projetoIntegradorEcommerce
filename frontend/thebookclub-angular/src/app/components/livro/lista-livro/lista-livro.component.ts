import { Component, ContentChild, Directive, Input, OnInit, TemplateRef } from '@angular/core';
import { Livro } from 'src/app/modelos/Livro';

@Directive({
  selector: '[appTemplateLivro]'
})
export class ListaLivroDirective {
  constructor(public templateRef: TemplateRef<unknown>) {}
}

@Component({
  selector: 'app-lista-livro',
  templateUrl: './lista-livro.component.html',
  styleUrls: ['./lista-livro.component.css']
})
export class ListaLivroComponent implements OnInit {

  @Input() listaLivros: Livro[];
  @Input()tituloLista: string;
  @ContentChild(ListaLivroDirective) content!:ListaLivroDirective;

  constructor() { }

  ngOnInit(): void {
  }

}
