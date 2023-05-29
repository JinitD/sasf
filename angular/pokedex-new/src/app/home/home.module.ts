import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './components/home/home.component';
import { PokemonCardComponent } from './components/pokemon-card/pokemon-card.component';
import { EditComponent } from './components/edit/edit.component';


@NgModule({
  declarations: [
    HomeComponent,
    PokemonCardComponent,
    EditComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
    , ReactiveFormsModule
  ]
})
export class HomeModule { }
