import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoscuComponent } from './components/coscu/coscu.component';
import { CoscuhomeComponent } from './components/coscuhome/coscuhome.component';

const routes: Routes = [{
  path: '',
  component: CoscuComponent
},
{
  path: 'home',
  component: CoscuhomeComponent
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoscuRoutingModule { }
