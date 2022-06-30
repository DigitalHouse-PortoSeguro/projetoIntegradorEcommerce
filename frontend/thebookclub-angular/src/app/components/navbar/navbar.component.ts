import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  tituloText: string = "";

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  buscaTitulo() {
    if (this.tituloText == "") return;

    this.router.navigate(['/livros/titulo', this.tituloText]);
  }

}
