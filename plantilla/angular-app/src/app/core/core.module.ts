import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from './service/user/user.service';
import { AuthService } from './service/auth/auth.service';
import { TokenService } from './service/token/token.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
  ,providers:[
    AuthService,
    UserService,
    TokenService
  ]
})
export class CoreModule { }
