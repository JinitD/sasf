import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDataliComponent } from './product-datali.component';

describe('ProductDataliComponent', () => {
  let component: ProductDataliComponent;
  let fixture: ComponentFixture<ProductDataliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductDataliComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductDataliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
