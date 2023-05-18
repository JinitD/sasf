import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FurnitureDetaileComponent } from './furniture-detaile.component';

describe('FurnitureDetaileComponent', () => {
  let component: FurnitureDetaileComponent;
  let fixture: ComponentFixture<FurnitureDetaileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FurnitureDetaileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FurnitureDetaileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
