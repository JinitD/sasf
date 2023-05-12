import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { Pokemon } from '../model/Pokemon';
import { Observable } from 'rxjs';
import { Category } from '../model/Category';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(
    private http: HttpClient
  ) { }

  getAllPokemons() {
    return this.http.get<Pokemon[]>(`/api/pokemon`);
  } 
  getPokemonById(idpokemon: number) {
    return this.http.get<Pokemon>(`/api/pokemon/${idpokemon}`);
  }
  getAllCategorys() {
    return this.http.get<Category[]>(`/api/category`);
  }
  postPokemon(newPokemon: Pokemon) {
    return this.http.post(`/api/pokemon`, newPokemon);
  }

  updateProduct(idpokemon: number, change?: Partial<Pokemon>) {
    return this.http.put(`/api/pokemon/${idpokemon}`, change);
  }
  
  deletePokemon(id: number): Observable<any> {
    return this.http.delete<any>(`/api/pokemon/${id}`);
  }

}
