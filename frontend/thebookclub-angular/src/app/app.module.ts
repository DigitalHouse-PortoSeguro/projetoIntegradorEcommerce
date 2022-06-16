import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UsuarioCadastroComponent } from './components/usuario-cadastro/usuario-cadastro.component';
import { InputCustomComponent } from './components/input-custom/input-custom.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputFieldComponent } from './components/input-field/input-field.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioCadastroComponent,
    InputCustomComponent,
    InputFieldComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
