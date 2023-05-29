import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/core/model/Category';
import { Pokemon } from 'src/app/core/model/Pokemon';
import { PokemonService } from 'src/app/core/services/pokemon.service';

@Component({
  selector: 'app-pokemon-card',
  templateUrl: './pokemon-card.component.html',
  styleUrls: ['./pokemon-card.component.scss']
})
export class PokemonCardComponent {
  form!: FormGroup;

  category: Category[] = [];
  constructor(private formBuilder: FormBuilder,
    private pokemonService: PokemonService,
    private router: Router) {
    this.fetchtCategory();
    this.buildForm();
  }

  fetchtCategory() {
    this.pokemonService.getAllCategorys().subscribe(res => {
      // console.log(res);
      this.category = res;
    })
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      idpokemon: ['', [Validators.required]],
      name: ['', [Validators.required, Validators.max(1)]],
      status: ['', [Validators.required]],
      category: ['']
    })
  }

  saveProduct(event: Event) {
    console.log(this.form.value)
    event.preventDefault();
    const pokemon: Pokemon = this.form.value;
    this.pokemonService.postPokemon(pokemon)
      .subscribe(prod => {
        // console.log(prod);
        this.router.navigate(['/home']);
      })
  }

}
