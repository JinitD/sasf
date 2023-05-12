import { Category } from "./Category";

export interface Pokemon {
    idpokemon: number;
    name: string;
    status: string;
    category: Category;
}