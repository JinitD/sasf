import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavComponent } from './components/nav/nav.component';
import { RouterModule } from '@angular/router';
import { FooterComponent } from './components/footer/footer.component';
import { SvgComponent } from './components/svg/svg.component';



@NgModule({
  declarations: [
    NavComponent,
    FooterComponent,
    SvgComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ], exports: [
    NavComponent,
    FooterComponent,
    SvgComponent
  ]
})
export class SharedModule { }
