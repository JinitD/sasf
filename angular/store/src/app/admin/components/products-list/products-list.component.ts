import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/core/service/products/products.service';
import { Product } from 'src/app/shared/model/product.model';


@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.scss']
})
export class ProductsListComponent implements OnInit {
  products!: Product[];

  displayedColumns: string[] = ['id', 'title', 'precio', 'action'];//x
  dataSource = this.products;//x

  constructor(private productsService: ProductsService) {
  }

  ngOnInit(): void {
    this.fetchProduct();
  }

  fetchProduct() {
    this.productsService.getAllProducts()
      .subscribe(items => {
        this.products = items;
      })
  }
  deleteProduct(id: string) {
    this.productsService.deletePorduct(id)
    .subscribe(rta =>{
      this.fetchProduct();
    })
  }


}
