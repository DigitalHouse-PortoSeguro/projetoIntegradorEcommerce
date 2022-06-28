import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioCadastroComponent } from './components/usuario/usuario-cadastro/usuario-cadastro.component';
import { UsuarioAtualizarComponent } from './components/usuario/usuario-atualizar/usuario-atualizar.component';
import { ListarUsuariosComponent } from './components/usuario/listar-usuarios/listar-usuarios.component';
import { GerenciarUsuarioComponent } from './components/usuario/gerenciar-usuario/gerenciar-usuario.component';
import { UsuarioAtualizarAdminComponent } from './components/usuario/usuario-atualizar-admin/usuario-atualizar-admin.component';
import { AppComponent } from './app.component';
import { LivrosTituloComponent } from './components/livro/livros-titulo/livros-titulo.component';
import { LivroCategoriaComponent } from './components/livro/livro-categoria/livro-categoria.component';
import { ProdutoLivroComponent } from './components/livro/produto-livro/produto-livro.component';
import { LivroCadastroComponent } from './components/livro/livro-cadastro/livro-cadastro.component';

const routes: Routes = [
  { path: "", redirectTo: "cadastrar", pathMatch: "full" },
  { path: "cadastrar", component: UsuarioCadastroComponent },//arrumar para usuarios/cadastrar
  { path: "atualizar", component: UsuarioAtualizarComponent },
  { path: "login", component: AppComponent },
  { path: "admin/listar-usuarios", component: ListarUsuariosComponent },
  { path: "admin/gerenciar-usuario/:id", component: GerenciarUsuarioComponent },
  { path: "admin/atualizar-usuario/:id", component: UsuarioAtualizarAdminComponent },
  { path: "livros/cadastrar", component: LivroCadastroComponent },
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
