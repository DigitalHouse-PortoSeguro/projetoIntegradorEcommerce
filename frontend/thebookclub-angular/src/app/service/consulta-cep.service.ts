import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ViaCEPEndereco } from '../modelos/ViaCEPEndereco';

@Injectable({
  providedIn: 'root'
})
export class ConsultaCepService {

  constructor(private http: HttpClient) { }

  consultaCEP(cep: string): Observable<ViaCEPEndereco> {
    return this.http.get<ViaCEPEndereco>(`https://viacep.com.br/ws/${cep}/json`);
  }

}
