import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Peticion } from '../../model/Peticion';

@Injectable({
  providedIn: 'root'
})
export class PeticionService {

  constructor(
    private http: HttpClient
  ) { }

  createPeticion(peticion: Peticion) {
    return this.http.post(`api/peticion`, peticion);
  }
  getAllPeticion() {
    return this.http.get<Peticion[]>(`/api/peticion`);
  }

}
