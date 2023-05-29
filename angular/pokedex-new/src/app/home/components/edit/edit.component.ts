import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Category } from 'src/app/core/model/Category';
import { Pokemon } from 'src/app/core/model/Pokemon';
import { PokemonService } from 'src/app/core/services/pokemon.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  pokemon?: Pokemon;
  form!: FormGroup;

  category: Category[] = [];

  idpokemon!: number;
  constructor(
    private formBuilder: FormBuilder,
    private pokemonService: PokemonService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.fetchtCategory();
    this.buildForm();
  }

  fetchtCategory() {
    this.pokemonService.getAllCategorys().subscribe(res => {
      // console.log(res);
      this.category = res;
    })
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.idpokemon = params['idpokemon'];

      this.pokemonService.getPokemonById(this.idpokemon)
        .subscribe(pokemon => {
          this.pokemon = pokemon
          this.form.patchValue(pokemon)
          // console.log(this.form.value)
        })
    

    })
  }

  editpokemon(event: Event) {
    event.preventDefault();
    this.pokemon = this.form.value;
    // console.log(this.pokemon)
    this.pokemonService.updateProduct(this.idpokemon, this.pokemon)
      .subscribe(prod => {
        this.router.navigate(['/home']);
      })
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      idpokemon: ['', [Validators.required]],
      name: ['', [Validators.required, Validators.maxLength(1)]],
      status: ['', [Validators.required]],
      category: ['Categoría', []]
    })
  }

}
