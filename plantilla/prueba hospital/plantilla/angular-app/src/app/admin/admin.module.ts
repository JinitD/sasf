import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './components/admin/admin.component';
import { NavComponent } from './components/nav/nav.component';
import { AgregarComponent } from './components/agregar/agregar/agregar.component';
import { ProfileComponent } from './components/profile/profile/profile.component';


@NgModule({
  declarations: [
    AdminComponent,
    NavComponent,
    AgregarComponent,
    ProfileComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
