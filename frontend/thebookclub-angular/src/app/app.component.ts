import { Component } from '@angular/core';
import { globals } from 'src/environments/environment.prod';
import { Livro } from './modelos/Livro';
import { Usuario } from './modelos/Usuario';
import { UsuarioLogin } from './modelos/UsuarioLogin';
import { LocalDate } from './utils/LocalDate';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'thebookclub-angular';

  constructor() {  }
}
