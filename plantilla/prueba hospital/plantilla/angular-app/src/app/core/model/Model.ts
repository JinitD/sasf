import { AreaCoService } from "../service/areaCo/area-co.service";

export interface User {
  iduser: number;
  username: string;
  email: string;
  password: string;
  nombre: string;
  lastname: string;
  status: string;
}

export interface Credencitals {
  email: string;
  password: string;
  role?: Role;
}

export interface Role {
  idrole: number;
  role: string;
}

export interface RoleDTO {
  idrole: number;
  name: string;
  users: User;
}

export interface Citas {
  id: number;
  fechacita: Date;
  observaciones: string;
  recetaMedica: string;
  status:string;
  areaConocimiento: AreaConocimineto
  enfermero: User;
  paciente:User;
  medico:User;

}

export interface AreaConocimineto {
  id: number;
  nombre: string;
  detalle: string;
}