import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from './service/user/user.service';
import { AuthService } from './service/auth/auth.service';



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
