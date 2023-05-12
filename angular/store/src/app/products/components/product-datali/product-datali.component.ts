import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { ProductsService } from 'src/app/core/service/products/products.service';
import { Product } from 'src/app/shared/model/product.model';

@Component({
  selector: 'app-product-datali',
  templateUrl: './product-datali.component.html',
  styleUrls: ['./product-datali.component.scss']
})
export class ProductDataliComponent implements OnInit {
  product!: Product;

  constructor(
    private route: ActivatedRoute,
    private productsService: ProductsService) {

  }
  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      const id: string = params["id"];
      this.featchProduct(id);
    });
  }
  featchProduct(id: string) {
    this.productsService.getProduct(id).subscribe(item => {
      this.product = item;
    });
  }
  crearProduct() {
    const newP: Product = {
      id: ``,
      idProduct: 22, title: "nuevo", img: 'assets/img/banner-3.jpg',
      price: 300, description: "nuevo producto"
    }
    this.productsService.createProduct(newP).subscribe(item => {
      console.log(item)
    });
  }

  updateProduct(id: string) {
    const updatep: Partial<Product> = {
      id: id,
      idProduct: 22, title: "nuevssssssso", img: 'assets/img/banner-3.jpg',
      price: 300, description: "nuevo producto"
    }
    this.productsService.updateProduct(id, updatep).subscribe(item => {
      console.log(item)
    });
  }

  deleteProduct(id: string) {
    this.productsService.deletePorduct(id).subscribe(res => {
      console.log(res)
    });
  }
}
