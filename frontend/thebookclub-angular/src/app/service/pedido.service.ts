import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment, globals } from 'src/environments/environment';
import { Pedido } from '../modelos/Pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(
    private http: HttpClient
  ) { }

  public cadastrarPedido(pedido: Pedido): Observable<Pedido> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.post<Pedido>(
      `${environment.BASE_URL}/pedidos/cadastrar`,
      globals.carrinho,
      { headers }
    );
  }

  public atualizarPedido(pedido: Pedido): Observable<Pedido> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.put<Pedido>(
      `${environment.BASE_URL}/pedidos/atualizar`,
      globals.carrinho,
      { headers }
    );
  }

  public deletarPedido(id: number): Observable<Pedido> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.delete<Pedido>(
      `${environment.BASE_URL}/pedidos/${id}`,
      { headers }
    );
  }

  public getPedidoById(id: number): Observable<Pedido> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.get<Pedido>(
      `${environment.BASE_URL}/pedidos/${id}`,
      { headers }
    );
  }

  public getPedidoByTipoPagamento(tipo: string): Observable<Pedido> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.get<Pedido>(
      `${environment.BASE_URL}/pedidos/tipoPagamento/${tipo}`,
      { headers }
    );
  }

  public getPedidoByFormaEnvio(forma: string): Observable<Pedido> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.get<Pedido>(
      `${environment.BASE_URL}/pedidos/formaEnvio/${forma}`,
      { headers }
    );
  }

  public getPedidoBStatus(status: string): Observable<Pedido> {
    const headers = new HttpHeaders()
      .set('Authorization', globals.usuarioLogin.token);

    return this.http.get<Pedido>(
      `${environment.BASE_URL}/pedidos/status/${status}`,
      { headers }
    );
  }
}
