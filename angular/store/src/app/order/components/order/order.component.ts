import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { CartService } from 'src/app/core/service/cart/cart.service';
import { Product } from 'src/app/shared/model/product.model';
CartService
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent {
  products$!: Observable<Product[]>;

  constructor(
    private cartService: CartService
  ) {
    this.products$ = cartService.cart$;
  }

}
