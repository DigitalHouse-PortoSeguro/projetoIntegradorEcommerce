import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioCadastroComponent } from './components/usuario/usuario-cadastro/usuario-cadastro.component';
import { UsuarioAtualizarComponent } from './components/usuario/usuario-atualizar/usuario-atualizar.component';
import { ListarUsuariosComponent } from './components/usuario/listar-usuarios/listar-usuarios.component';
import { GerenciarUsuarioComponent } from './components/usuario/gerenciar-usuario/gerenciar-usuario.component';
import { UsuarioAtualizarAdminComponent } from './components/usuario/usuario-atualizar-admin/usuario-atualizar-admin.component';
import { CarrinhoComponent } from './views/carrinho/carrinho.component';
import { LivrosTituloComponent } from './components/livro/livros-titulo/livros-titulo.component';
import { LivroCategoriaComponent } from './components/livro/livro-categoria/livro-categoria.component';
import { ProdutoLivroComponent } from './components/livro/produto-livro/produto-livro.component';
import { LivroCadastroComponent } from './components/livro/livro-cadastro/livro-cadastro.component';
import { EntrarComponent } from './components/entrar/entrar.component';
import { InicioComponent } from './views/inicio/inicio.component';
import { ListagemLivrosComponent } from './components/livro/listagem-livros/listagem-livros.component';
import { GerenciarLivroComponent } from './components/livro/gerenciar-livro/gerenciar-livro.component';
import { AtualizarLivroComponent } from './components/livro/atualizar-livro/atualizar-livro.component';
import { SairComponent } from './components/sair/sair.component';
import { LivroAtualizarComponent } from './components/livro/livro-atualizar/livro-atualizar.component';
import { AdminComponent } from './components/admin/admin.component';
import { CategoriasGeralComponent } from './components/categorias-geral/categorias-geral.component';

const routes: Routes = [
  { path: "", redirectTo: "inicio", pathMatch: "full" },
  
  { path: "inicio", component: InicioComponent },//home page do usuario
  { path: "cadastrar", component: UsuarioCadastroComponent },//arrumar para usuarios/cadastrar
  { path: "atualizar", component: UsuarioAtualizarComponent },
  { path: "entrar", component: EntrarComponent },
  { path: "sair", component: SairComponent },
  { path: "admin", component: AdminComponent },
  { path: "admin/usuarios/cadastrar", component: UsuarioCadastroComponent },
  { path: "admin/usuarios/lista", component: ListarUsuariosComponent },
  { path: "admin/usuarios/gerenciar/:id", component: GerenciarUsuarioComponent },
  { path: "admin/usuarios/atualizar/:id", component: UsuarioAtualizarAdminComponent },
  
  { path: "admin/livros/cadastrar", component: LivroCadastroComponent },
  { path: "admin/livros/atualizar/:id", component: LivroAtualizarComponent },
  { path: "admin/livros/lista", component: ListagemLivrosComponent },
  { path: "admin/livros/gerenciar/:id", component: GerenciarLivroComponent },
  
  { path: "livros/categorias", component: CategoriasGeralComponent},
  { path: "livros/titulo/:titulo", component: LivrosTituloComponent },
  { path: "livros/categoria/:categoria", component: LivroCategoriaComponent},
  { path: "livros/produto/:id", component: ProdutoLivroComponent },
  { path: "carrinho", component: CarrinhoComponent}
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
