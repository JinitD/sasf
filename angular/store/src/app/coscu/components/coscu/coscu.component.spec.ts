import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoscuComponent } from './coscu.component';

describe('CoscuComponent', () => {
  let component: CoscuComponent;
  let fixture: ComponentFixture<CoscuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoscuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoscuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
