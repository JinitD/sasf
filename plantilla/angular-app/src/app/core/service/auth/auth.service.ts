import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Credencitals } from '../../model/Model';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  signinAuth(creds: Credencitals) {
    return this.http.post(`/api/auth/signin`, creds, { observe: 'response' }).pipe(
      map((response: HttpResponse<any>) => {

        const body = response.body;
        const headers = response.headers;
        const bearerToken = headers.get('Authorization')!;
        const token = bearerToken.replace('Bearer', '');
        localStorage.setItem('token', token);
        return body;
      })
    );
  }

  signupAuth() {
    // Implementa la lógica para registrarse aquí
  }
}
