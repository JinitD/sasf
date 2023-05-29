import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavComponent } from './components/nav/nav.component';
import { RouterModule } from '@angular/router';
import { NavMenuComponent } from './components/nav-menu/nav-menu.component';
import { FooterComponent } from './components/footer/footer.component';



@NgModule({
  declarations: [
    NavComponent,
    NavMenuComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    RouterModule,

  ],exports: [
    NavComponent,
    FooterComponent,
    NavMenuComponent,
  ]
})
export class SharedModule { }
