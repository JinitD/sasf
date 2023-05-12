import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from 'src/app/shared/model/product.model';
import { environment } from 'src/environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {


  constructor(
    private http: HttpClient
  ) { }

  getAllProducts() {
    return this.http.get<Product[]>(`${environment.url_api}/productos`);
  }
  getProduct(id: string) {
    return this.http.get<Product>(`${environment.url_api}/productos/${id}`);
  }
  createProduct(product: Product) {
    return this.http.post(`${environment.url_api}/productos`, product);
  }

  updateProduct(id: string, change: Partial<Product>) {
    return this.http.put(`${environment.url_api}/productos/${id}`, change);
  }

  deletePorduct(id: string) {
    return this.http.delete(`${environment.url_api}/productos/${id}`);
  }
}
