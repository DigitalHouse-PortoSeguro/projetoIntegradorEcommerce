import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { globals } from 'src/environments/environment.prod';
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
    
    return this.http.post<Livro>('http://localhost:8080/livros/cadastrar', livro, { headers });
  }

  public atualizarLivro(livro: Livro): Observable<Livro> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
    return this.http.put<Livro>('http://localhost:8080/livros/atualizar', livro, { headers });
  }

  public deletarLivro(id: number): Observable<Livro> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);
    
    return this.http.delete<Livro>(`http://localhost:8080/livros/${id}`, { headers });
  }

  public getAllCategorias(): Observable<string[]> {
    return this.http.get<string[]>(`http://localhost:8080/livros/categorias`);
  }

  public getAllLivros(): Observable<Livro[]> {
    return this.http.get<Livro[]>(`http://localhost:8080/livros`);
  }

  public getLivroById(id: number): Observable<Livro> {
    return this.http.get<Livro>(`http://localhost:8080/livros/${id}`);
  }

  public getAllLivrosByCategoria(categoria: string): Observable<Livro> {
    return this.http.get<Livro>(`http://localhost:8080/livros/categoria/${categoria}`);
  }

  public getAllLivrosByTitulo(titulo: string): Observable<Livro> {
    return this.http.get<Livro>(`http://localhost:8080/livros/titulo/${titulo}`);
  }
}
