import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { IViaCEPEndereco } from '../modelos/ViaCEPEndereco';

@Injectable({
  providedIn: 'root'
})
export class ConsultaCepService {

  constructor(private http: HttpClient) { }

  consultaCEP(cep: string): Observable<IViaCEPEndereco> {
    return this.http.get<IViaCEPEndereco>(`https://viacep.com.br/ws/${cep}/json`);
  }

}
