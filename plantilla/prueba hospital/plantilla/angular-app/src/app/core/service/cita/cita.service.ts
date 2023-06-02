import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AreaConocimineto, Citas } from '../../model/Model';

@Injectable({
  providedIn: 'root'
})
export class CitaService {
  
  constructor(
    private http: HttpClient
  ) { }

  getAllCitas() {
    return this.http.get<Citas[]>(`/api/privade/citas`);
  }
  getOneCitasById(id: number) {
    return this.http.get<Citas>(`/api/privade/citas/${id}`);
  }
  getAllArea() {
    return this.http.get<AreaConocimineto[]>(`/api/privade/areaCo`);
  }
}
