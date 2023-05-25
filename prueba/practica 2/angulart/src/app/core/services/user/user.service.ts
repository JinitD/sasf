import { Injectable } from '@angular/core';
import { Usuario } from '../../model/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient
  ) { }

  getAll() {
    return this.http.get<Usuario[]>(`/api/usuario`);
  }
  getbyId(idusuario: string) {
    return this.http.get<Usuario>(`/api/usuario/${idusuario}`);
  }
}
