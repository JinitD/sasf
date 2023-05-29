import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Inmueble } from '../../model/Inmueble';

@Injectable({
  providedIn: 'root'
})
export class InmuebleService {
  constructor(
    private http: HttpClient
  ) { }


  getAllinmuebles() {
    return this.http.get<Inmueble[]>(`/api/inmueble`);
  }
  getbyIdInmueble(idinmueble: string) {
    return this.http.get<Inmueble>(`/api/inmueble/${idinmueble}`);
  }



}
