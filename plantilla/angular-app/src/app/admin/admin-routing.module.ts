import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { NavComponent } from './components/nav/nav.component';
import { AgregarComponent } from './components/agregar/agregar/agregar.component';
import { ProfileComponent } from '../page/components/profile/profile.component';

const routes: Routes = [
  {
    path: '', component: NavComponent
    , children: [
      { path: '', redirectTo: 'menu', pathMatch: 'full' },
      { path: 'menu', component: AdminComponent },
      { path: 'agregar', component: AgregarComponent },
      { path: 'profile', component: ProfileComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
