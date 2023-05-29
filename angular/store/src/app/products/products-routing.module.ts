import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { ProductDataliComponent } from './components/product-datali/product-datali.component';

const routes: Routes = [
  {
    path: '',
    component: ListComponent
  }, {
    path: ':id', 
    component: ProductDataliComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductsRoutingModule { }
