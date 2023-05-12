import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ProductsService } from 'src/app/core/service/products/products.service';
import { Product } from 'src/app/shared/model/product.model';
import { MyValidators } from 'src/app/utils/MyValidators';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.scss']
})
export class ProductEditComponent implements OnInit {
  form!: FormGroup;
  id!: string;
  constructor(private formBuilder: FormBuilder,
    private productsService: ProductsService,
    private router: Router
    , private activatedRoute: ActivatedRoute) {
    this.buildForm();
  }
  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.id = params['id'];
      console.log(this.id)
      this.productsService.getProduct(this.id)
        .subscribe(product => {
          this.form.patchValue(product)
        })
    })
  }

  saveProduct(event: Event) {
    event.preventDefault();
    if (this.form.valid) {
      const product: Product = this.form.value;
      this.productsService.updateProduct(this.id, product)
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
