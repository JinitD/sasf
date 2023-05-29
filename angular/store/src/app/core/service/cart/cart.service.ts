import { Injectable } from '@angular/core';
import { Product } from '../../../shared/model/product.model'

import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CartService {
  private products: Product[] = []
  private cart: BehaviorSubject<Product[]> = new BehaviorSubject<Product[]>([])

  cart$ = this.cart.asObservable();
  constructor() { }

  addCarrito(product: Product) {
    this.products = [...this.products, product];
    this.cart.next(this.products);
  }
}
