import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  getToken():string {
    return localStorage.getItem('token')!;
  }

   getDecodeToken() {
    return jwt_decode(this.getToken())as { exp: number, roles: string[]  ,sub:string};
  }
}
