import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IntegracionRoutingModule } from './integracion-routing.module';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';


@NgModule({
  declarations: [
    ContactComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    IntegracionRoutingModule
  ]
})
export class IntegracionModule { }
