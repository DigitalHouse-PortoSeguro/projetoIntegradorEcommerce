import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment, globals } from 'src/environments/environment';
import { Usuario } from '../modelos/Usuario';
import { UsuarioLogin } from '../modelos/UsuarioLogin';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  constructor(
    private http: HttpClient
  ) {}

  public cadastrarUsuario(usuario: Usuario): Observable<Usuario> {
    let options = {};
    if (this.isLoggedIn()) {
      options = {
        headers: new HttpHeaders()
          .set('Authorization', globals.usuarioLogin.token)
      }
    }
    return this.http.post<Usuario>(`${environment.BASE_URL}/usuarios/cadastrar`, usuario, options);
  }

  public logarUsuario(usuario: UsuarioLogin): Observable<UsuarioLogin> {
    return this.http.post<UsuarioLogin>(`${environment.BASE_URL}/usuarios/login`, usuario);
  }

  public atualizarUsuario(usuario: Usuario): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.put<Usuario>(`${environment.BASE_URL}/usuarios/atualizar`, usuario, { headers });
  }

  public saveUsuarioLocalStorage(): void {
    localStorage.setItem("__USER_LOGIN", JSON.stringify(globals.usuarioLogin));
  }

  public loadUsuarioLocalStorage(): void {
    const userItem = localStorage.getItem("__USER_LOGIN");
    if (userItem != null) {
      const userObj = JSON.parse(userItem);
      Object.assign(globals.usuarioLogin, userObj);
    }
  }

  public getAllUsuarios(): Observable<Usuario[]> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
    return this.http.get<Usuario[]>(`${environment.BASE_URL}/usuarios`, { headers });
  }

  public getById(id: number): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
    return this.http.get<Usuario>(`${environment.BASE_URL}/usuarios/${id}`, { headers });
  }
  public getUsuarioByNome(nome: string): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    return this.http.get<Usuario>(`${environment.BASE_URL}/usuarios/nome/${nome}`, { headers });
  }
  public getUsuarioByUsername(username: string): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    return this.http.get<Usuario>(`${environment.BASE_URL}/usuarios/username/${username}`, { headers });
  }
  public getUsuarioByEmail(email: string): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    return this.http.get<Usuario>(`${environment.BASE_URL}/usuarios/email/${email}`, { headers });
  }
  public getUsuarioByCpf(cpf: string): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    return this.http.get<Usuario>(`${environment.BASE_URL}/usuarios/cpf/${cpf}`, { headers });
  }

  public deleteById(id: number): Observable<Usuario> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
      return this.http.delete<Usuario>(`${environment.BASE_URL}/usuarios/${id}`, { headers });
  }

  public logout(): void {
    globals.usuarioLogin = new UsuarioLogin();
    localStorage.removeItem("__USER_LOGIN");
  }

  public getUsuarioLogin(): UsuarioLogin {
    return globals.usuarioLogin;
  }

  public getUsuario(): Usuario {
    const user = new Usuario();

    user.usuarioId = globals.usuarioLogin.usuarioId;
    user.nome = globals.usuarioLogin.nome;
    user.sobrenome = globals.usuarioLogin.sobrenome;
    user.cpf = globals.usuarioLogin.cpf;
    user.username = globals.usuarioLogin.username;
    user.tipoUsuario = globals.usuarioLogin.tipoUsuario;
    user.email = globals.usuarioLogin.email;
    user.senha = globals.usuarioLogin.senha;
    user.dataNascimento = globals.usuarioLogin.dataNascimento;
    user.preferencias = globals.usuarioLogin.preferencias;
    user.rua = globals.usuarioLogin.rua;
    user.numero = globals.usuarioLogin.numero;
    user.bairro = globals.usuarioLogin.bairro;
    user.cep = globals.usuarioLogin.cep;
    user.complemento = globals.usuarioLogin.complemento;
    user.foto = globals.usuarioLogin.foto;

    return user;
  }

  public isLoggedIn(): boolean {
    if (globals.usuarioLogin && globals.usuarioLogin.token) {
      return globals.usuarioLogin.token !== "";
    }
    return false;
  }

  public isAdmin(): boolean {
    if (globals.usuarioLogin && globals.usuarioLogin.tipoUsuario) {
      return globals.usuarioLogin.tipoUsuario === "ADMIN";
    }
    return false;
  }
}
