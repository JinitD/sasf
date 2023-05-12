import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonService } from './services/pokemon.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],providers:[
    PokemonService
  ]
})
export class CoreModule { }
