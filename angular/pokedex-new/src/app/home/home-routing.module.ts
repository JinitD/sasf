import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { EditComponent } from './components/edit/edit.component';
import { PokemonCardComponent } from './components/pokemon-card/pokemon-card.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  { path: 'edit/:idpokemon', component: EditComponent },
  { path: 'add', component: PokemonCardComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
