import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioCadastroComponent } from './components/usuario-cadastro/usuario-cadastro.component';
import { UsuarioAtualizarComponent } from './components/usuario-atualizar/usuario-atualizar.component';
import { ListarUsuariosComponent } from './components/listar-usuarios/listar-usuarios.component';
import { GerenciarUsuarioComponent } from './components/gerenciar-usuario/gerenciar-usuario.component';
import { UsuarioAtualizarAdminComponent } from './components/usuario-atualizar-admin/usuario-atualizar-admin.component';
import { EntrarComponent } from './components/entrar/entrar.component';

const routes: Routes = [
  { path: "", redirectTo: "entrar", pathMatch: "full" },
  { path: "cadastrar", component: UsuarioCadastroComponent },
  { path: "atualizar", component: UsuarioAtualizarComponent },
  { path: "admin/listar-usuarios", component: ListarUsuariosComponent },
  { path: "admin/gerenciar-usuario/:id", component: GerenciarUsuarioComponent },
  { path: "admin/atualizar-usuario/:id", component: UsuarioAtualizarAdminComponent },
  { path: "entrar", component: EntrarComponent},
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
