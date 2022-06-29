import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioCadastroComponent } from './components/usuario-cadastro/usuario-cadastro.component';
import { UsuarioAtualizarComponent } from './components/usuario-atualizar/usuario-atualizar.component';
import { CarrinhoComponent } from './views/carrinho/carrinho.component';

const routes: Routes = [
  {path: "", redirectTo:"cadastrar", pathMatch:"full"},
  { path: "cadastrar", component: UsuarioCadastroComponent },
  { path: "atualizar", component: UsuarioAtualizarComponent },
  { path: "carrinho", component: CarrinhoComponent},
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
