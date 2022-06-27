import { Component, ContentChild, Directive, Input, OnInit, TemplateRef } from '@angular/core';
import { Livro } from 'src/app/modelos/Livro';

@Component({
  selector: 'app-lista-livro',
  templateUrl: './lista-livro.component.html',
  styleUrls: ['./lista-livro.component.css']
})
export class ListaLivroComponent implements OnInit {

  @Input() listaLivros: Livro[];
  @Input() tituloLista: string;

  constructor() { }

  ngOnInit(): void {
  }

}
