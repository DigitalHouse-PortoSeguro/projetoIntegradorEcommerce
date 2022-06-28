import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioCadastroComponent } from './components/usuario-cadastro/usuario-cadastro.component';
import { UsuarioAtualizarComponent } from './components/usuario-atualizar/usuario-atualizar.component';
import { LivrosTituloComponent } from './components/livro/livros-titulo/livros-titulo.component';
import { LivroCategoriaComponent } from './components/livro/livro-categoria/livro-categoria.component';
import { ProdutoLivroComponent } from './components/livro/produto-livro/produto-livro.component';

const routes: Routes = [
  { path: "", redirectTo: "cadastrar", pathMatch: "full" },
  { path: "cadastrar", component: UsuarioCadastroComponent },
  { path: "atualizar", component: UsuarioAtualizarComponent },
  { path: "livros/titulo/:titulo", component: LivrosTituloComponent },
  { path: "livros/categoria/:categoria", component: LivroCategoriaComponent},
  { path: "livros/produto/:id", component: ProdutoLivroComponent }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
