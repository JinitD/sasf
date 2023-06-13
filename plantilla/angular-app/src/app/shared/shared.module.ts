import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterComponent } from './components/footer/footer.component';
import { RouterModule } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';



@NgModule({
  declarations: [
    FooterComponent,
    NavComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
  ],exports: [
    FooterComponent,
    NavComponent
  ]
})
export class SharedModule { }
