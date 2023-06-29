import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../../model/Model';
import { AuthService } from '../auth/auth.service';
import { TokenService } from '../token/token.service';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private authser: AuthService,
    private http: HttpClient,
    private tokenService :TokenService
  ) { }

  getAllUsers() {
    return this.http.get<User[]>(`/api/privade/users`);
  }
  getOneUserById(id: number) {
    return this.http.get<User[]>(`/api/privade/users/${id}`);
  }

  getOneUserByEmail() {
    const decodetoken = this.tokenService.getDecodeToken();
    let data: any = {
      email: decodetoken.sub
    }
    console.log('enviadso')
    console.log(data)
    return this.http.get<User>(`/api/privade/users/profile`, data);
  }


}
