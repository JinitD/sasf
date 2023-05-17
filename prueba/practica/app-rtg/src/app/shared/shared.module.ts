import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavComponent } from './components/nav/nav.component';
import { RouterModule } from '@angular/router';
import { NavMenuComponent } from './components/nav-menu/nav-menu.component';



@NgModule({
  declarations: [
    NavComponent,
    NavMenuComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],exports: [
    NavComponent
  ]
})
export class SharedModule { }
