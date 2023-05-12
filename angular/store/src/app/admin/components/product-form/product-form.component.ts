import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductsService } from 'src/app/core/service/products/products.service';
import { Product } from 'src/app/shared/model/product.model';
import { MyValidators } from 'src/app/utils/MyValidators';


@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent {
  form!: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private productsService: ProductsService,
    private router: Router) {
    this.buildForm();
  }

  saveProduct(event: Event) {
    event.preventDefault();
    if (this.form.valid) {
      const product: Product = this.form.value;
      this.productsService.createProduct(product)
        .subscribe(prod => {
          console.log(prod);
          this.router.navigate(['/admin/products']);
        })
    }
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      idProduct: ['', [Validators.required]],
      title: ['', [Validators.required]],
      price: ['', [Validators.required, MyValidators.isPriceValid]],
      img: [''],
      description: ['', [Validators.required]]
    })
  }
  get priceField() {
    return this.form.get('price')
  }
}
