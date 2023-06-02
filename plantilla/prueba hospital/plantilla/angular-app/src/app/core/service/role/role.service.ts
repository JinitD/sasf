import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Role, RoleDTO } from '../../model/Model';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(
    private http: HttpClient
  ) { }

  getAllRole() {
    return this.http.get<RoleDTO[]>(`/api/privade/role`);
  }

}
