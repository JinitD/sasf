import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuRoutingModule } from './menu-routing.module';
import { BookingComponent } from './componentes/booking/booking.component';
import { PetitionComponent } from './componentes/petition/petition.component';
import { FurnitureComponent } from './componentes/furniture/furniture.component';
import { FurnitureDetaileComponent } from './componentes/furniture-detaile/furniture-detaile.component';


@NgModule({
  declarations: [
    BookingComponent,
    PetitionComponent,
    FurnitureComponent,
    FurnitureDetaileComponent
  ],
  imports: [
    CommonModule,
    MenuRoutingModule
  ]
})
export class MenuModule { }
