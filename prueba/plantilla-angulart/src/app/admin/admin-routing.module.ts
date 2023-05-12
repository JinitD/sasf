import { NgModule } from '@angular/core';
import {  RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { NavComponent } from './components/nav/nav.component';

const routes: Routes = [
  {
    path: '', component: NavComponent, children: [
      { path: 'list', component: ListComponent },
      // { path: 'table', component: TableComponent },
      // { path: 'dashboard', component: DashboardComponent },
      // { path: 'products', component: ProductsListComponent },
      // { path: 'products/create', component: ProductFormComponent },
      //{ path: 'products/edit/:id', component: ProductEditComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
