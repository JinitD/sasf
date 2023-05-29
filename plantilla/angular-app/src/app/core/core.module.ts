import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from './service/auth/auth.service';
import { UserService } from './service/user/user.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
  ,providers:[
    AuthService,
    UserService
  ]
})
export class CoreModule { }
