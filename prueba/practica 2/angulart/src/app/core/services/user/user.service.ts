import { Injectable } from '@angular/core';
import { User } from '../../model/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient
  ) { }

  getAll() {
    return this.http.get<User[]>(`/api/inmueble`);
  }
  getbyId(idusuario: string) {
    return this.http.get<User>(`/api/inmueble/${idusuario}`);
  }
}
