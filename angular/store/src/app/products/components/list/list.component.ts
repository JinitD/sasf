import { Component } from '@angular/core';
import { ProductsService } from 'src/app/core/service/products/products.service';
import { Product } from 'src/app/shared/model/product.model';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent {
  products!: Product[];

  constructor(private productsService: ProductsService) {
    this.fetchProducts();
  }
  clickProduc(id: number) {
    console.log(id)
  }
  fetchProducts() {
    this.productsService.getAllProducts().subscribe(products => {
      this.products = products;
      console.log(this.products)
    });
  }

}
