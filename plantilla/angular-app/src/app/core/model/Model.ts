export interface User {
  iduser:number;
  username:string;
  email: string;
  password: string;
  firstname:string;
  lastname:string;
  status:string;
  role:Role;

}

export interface Credencitals {
  email: string;
  password: string;
  role?:Role;
}

export interface Role {
  idrole: number;
  role: string;
}
