import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common'


import { AppComponent } from './app.component';
import { FormUsuarioComponent } from './components/form-usuario/form-usuario.component';
import { InputCustomComponent } from './components/input-custom/input-custom.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputFieldComponent } from './components/input-field/input-field.component';
import { DropdownComponent } from './components/dropdown/dropdown.component';
import { FormDebugComponent } from './components/form-debug/form-debug.component';
import { HttpClientModule } from '@angular/common/http';
import { CardLivroComponent } from './components/livro/card-livro/card-livro.component';
import { UsuarioCadastroComponent } from './components/usuario-cadastro/usuario-cadastro.component';
import { UsuarioAtualizarComponent } from './components/usuario-atualizar/usuario-atualizar.component';
import { ProdutoLivroComponent } from './components/livro/produto-livro/produto-livro.component';
import { ListaLivroComponent } from './components/livro/lista-livro/lista-livro.component';
import { CategoriasGeralComponent } from './views/categorias-geral/categorias-geral.component';
import { CarrinhoComponent } from './views/carrinho/carrinho.component';
import { ItemCarrinhoComponent } from './components/item-carrinho/item-carrinho.component';
import { CalcFreteComponent } from './components/calc-frete/calc-frete.component';


@NgModule({
  declarations: [
    AppComponent,
    FormUsuarioComponent,
    InputCustomComponent,
    InputFieldComponent,
    DropdownComponent,
    FormDebugComponent,
    CardLivroComponent,
    UsuarioCadastroComponent,
    UsuarioAtualizarComponent,
    ProdutoLivroComponent,
    ListaLivroComponent,
    CategoriasGeralComponent,
    CarrinhoComponent,
    ItemCarrinhoComponent,
    CalcFreteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
