import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { IsExpiredGuard } from './helper/guard/token/is-expired.guard';
import { AuthGuard } from './helper/guard/auth/auth.guard';

const routes: Routes = [
 {path: '', component:LayoutComponent,
children:[
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
    ,   canActivate:[IsExpiredGuard],
  }, {
    path: 'sesion',
    loadChildren: () => import('./sesion/sesion.module').then(m => m.SesionModule)
    ,   canActivate:[IsExpiredGuard],
  },
  {
    path: 'paciente' ,
    loadChildren: () => import('./page/page.module').then(m => m.PageModule),
    canActivate:[AuthGuard] , data: { roles: ['PACIENTE',] }
  },
  {
    path: 'admin',
    loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),
    canActivate:[AuthGuard] , data: { roles: ['ADMIN',] }
  },

]}, {
  path: '**',
  loadChildren: () => import('./error/error.module').then(m => m.ErrorModule)
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
