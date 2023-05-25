import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SesionRoutingModule } from './sesion-routing.module';
import { LoginComponent } from './components/login/login.component';
import { SigupComponent } from './components/sigup/sigup.component';


@NgModule({
  declarations: [
    LoginComponent,
    SigupComponent
  ],
  imports: [
    CommonModule,
    SesionRoutingModule
  ]
})
export class SesionModule { }
