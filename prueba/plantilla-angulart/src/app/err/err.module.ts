import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ErrRoutingModule } from './err-routing.module';
import { ErrComponent } from './components/err/err.component';


@NgModule({
  declarations: [
    ErrComponent
  ],
  imports: [
    CommonModule,
    ErrRoutingModule
  ]
})
export class ErrModule { }
