import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsRoutingModule } from './products-routing.module';
import { ListComponent } from './components/list/list.component';
import { ProductDataliComponent } from './components/product-datali/product-datali.component';
import { ProductComponent } from './components/product/product.component';
import { MaterialModule } from '../material/material.module';


@NgModule({
  declarations: [
    ListComponent,
    ProductDataliComponent,
    ProductComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ProductsRoutingModule
  ]
})
export class ProductsModule { }
