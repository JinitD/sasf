import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuRoutingModule } from './menu-routing.module';
import { BookingComponent } from './componentes/booking/booking.component';
import { PetitionComponent } from './componentes/petition/petition.component';
import { FurnitureComponent } from './componentes/furniture/furniture.component';


@NgModule({
  declarations: [
    BookingComponent,
    PetitionComponent,
    FurnitureComponent
  ],
  imports: [
    CommonModule,
    MenuRoutingModule
  ]
})
export class MenuModule { }
