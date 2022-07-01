import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment, globals } from 'src/environments/environment';
import { Livro } from '../modelos/Livro';

@Injectable({
  providedIn: 'root'
})
export class LivroService {
  constructor(
    private http: HttpClient
  ) { }

  public cadastrarLivro(livro: Livro): Observable<Livro> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
    return this.http.post<Livro>(`${environment.BASE_URL}/livros/cadastrar`, livro, { headers });
  }

  public atualizarLivro(livro: Livro): Observable<Livro> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
    return this.http.put<Livro>(`${environment.BASE_URL}/livros/atualizar`, livro, { headers });
  }

  public deletarLivro(id: number): Observable<Livro> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
    return this.http.delete<Livro>(`${environment.BASE_URL}/livros/${id}`, { headers });
  }

  public getAllCategorias(): Observable<string[]> {
    return this.http.get<string[]>(`${environment.BASE_URL}/livros/categorias`);
  }

  public getAllLivros(): Observable<Livro[]> {
    return this.http.get<Livro[]>(`${environment.BASE_URL}/livros`);
  }

  public getLivroById(id: number): Observable<Livro> {
    return this.http.get<Livro>(`${environment.BASE_URL}/livros/${id}`);
  }

  public getAllLivrosByCategoria(categoria: string): Observable<Livro[]> {
    return this.http.get<Livro[]>(`${environment.BASE_URL}/livros/categoria/${categoria}`);
  }

  public getAllLivrosByTitulo(titulo: string): Observable<Livro[]> {
    return this.http.get<Livro[]>(`${environment.BASE_URL}/livros/titulo/${titulo}`);
  }
}
