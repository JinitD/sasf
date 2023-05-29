import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavMenuComponent } from '../shared/components/nav-menu/nav-menu.component';
import { FurnitureComponent } from './componentes/furniture/furniture.component';
import { BookingComponent } from './componentes/booking/booking.component';
import { PetitionComponent } from './componentes/petition/petition.component';
import { FurnitureDetaileComponent } from './componentes/furniture-detaile/furniture-detaile.component';
import { ProfileComponent } from './componentes/profile/profile.component';

const routes: Routes = [

  {
    path: '', component: NavMenuComponent,
    children: [
      { path: '', redirectTo: '/furniture', pathMatch: 'full' },
      { path: 'furniture', component: FurnitureComponent },
      { path: 'furniture/:idinmueble', component: FurnitureDetaileComponent },
      { path: 'booking', component: BookingComponent },
      { path: 'petition', component: PetitionComponent },
      { path: 'profile', component: ProfileComponent }
    ]
  },


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MenuRoutingModule { }
