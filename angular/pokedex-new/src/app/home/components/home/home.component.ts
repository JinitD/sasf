import { Component, Input } from '@angular/core';
import { Pokemon } from 'src/app/core/model/Pokemon';
import { PokemonService } from 'src/app/core/services/pokemon.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  pokemons: Pokemon[] = [];

  constructor(
    private pokemonService: PokemonService
  ) {
    this.fetchPokemons();
  }

  fetchPokemons() {
    this.pokemonService.getAllPokemons().subscribe(res => {
      // console.log(res);
      this.pokemons = res;
    })
  }

  deleteProduct(id: number) {
    this.pokemonService.deletePokemon(id).subscribe(item => {
      console.log("se guardo elimino correctamente")
      this.fetchPokemons()
    }, err => {
      console.log("erro al eliminar")
      console.log(err)
    })
  }
}
