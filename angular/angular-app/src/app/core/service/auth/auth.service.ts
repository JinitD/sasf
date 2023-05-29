import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import jwt_decode from 'jwt-decode';
import { Role } from '../../model/Model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  signinAuth(creds: Credential) {
    return this.http.post(`/api/login`, creds, {
      observe: 'response'
    }).pipe(map((response: HttpResponse<any>) => {
      const body = response.body;
      const headers = response.headers;
      const bearerToken = headers.get('Authorization')!;
      const token = bearerToken.replace('Bearer','');

      localStorage.setItem('token',token);

      return body;
    }));

  }

  getToken(){
    return localStorage.getItem('token')
  }
  getRole(){
    return localStorage.getItem('role')
  }
  signupAuth() {

  }
}
