import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { NavComponent } from './components/nav/nav.component';
import { ListComponent } from './components/list/list.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    NavComponent,
    ListComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,  
    ReactiveFormsModule

  ]
})
export class AdminModule { }
