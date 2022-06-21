import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { globals } from 'src/environments/environment.prod';
import { Usuario } from '../modelos/Usuario';
import { UsuarioLogin } from '../modelos/UsuarioLogin';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  constructor(
    private http: HttpClient
  ) { }

  public cadastrarUsuario(usuario: Usuario): Observable<Usuario> {
    let options = {};
    if (this.isLoggedIn()) {
      options = {
        headers: new HttpHeaders()
          .set('Authorization', globals.usuarioLogin.token)
      }
    }
    return this.http.post<Usuario>('http://localhost:8080/usuarios/cadastrar', usuario, options);
  }

  public logarUsuario(usuario: UsuarioLogin): Observable<UsuarioLogin> {
    return this.http.post<UsuarioLogin>('http://localhost:8080/usuarios/login', usuario);
  }

  public atualizarUsuario(usuario: Usuario): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.put<Usuario>('http://localhost:8080/usuarios/atualizar', usuario, { headers });
  }

  public isAdmin(): boolean {
    return globals.usuarioLogin?.tipoUsuario === "ADMIN";
  }
}
