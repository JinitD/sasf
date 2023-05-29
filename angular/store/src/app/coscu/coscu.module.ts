import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoscuRoutingModule } from './coscu-routing.module';
import { CoscuComponent } from './components/coscu/coscu.component';
import { CoscuhomeComponent } from './components/coscuhome/coscuhome.component';


@NgModule({
  declarations: [
    CoscuComponent,
    CoscuhomeComponent
  ],
  imports: [
    CommonModule,
    CoscuRoutingModule
  ]
})
export class CoscuModule { }
