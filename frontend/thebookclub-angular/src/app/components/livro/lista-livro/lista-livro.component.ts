import { Component, ContentChild, Directive, EventEmitter, Input, OnInit, Output, TemplateRef } from '@angular/core';
import { Livro } from 'src/app/modelos/Livro';

@Component({
  selector: 'app-lista-livro',
  templateUrl: './lista-livro.component.html',
  styleUrls: ['./lista-livro.component.css']
})
export class ListaLivroComponent implements OnInit {

  @Input() listaLivros: Livro[];
  @Output() select: EventEmitter<number> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  onLivroSelect(id: number): void {
    this.select.emit(id);
  }

}
