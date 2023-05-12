import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CartService } from 'src/app/core/service/cart/cart.service';
import { Product } from 'src/app/shared/model/product.model';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent {
  @Input() product!: Product;
  constructor(
    private cartService:CartService
  ){
    
  }

  @Output() proclickAddCar: EventEmitter<number> = new EventEmitter();
  today = new Date();
  
  addCar(): void {
      console.log('agregar al carrito')
      this.cartService.addCarrito(this.product)
  }

}
