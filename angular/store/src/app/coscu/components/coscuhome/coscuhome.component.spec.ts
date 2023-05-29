import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoscuhomeComponent } from './coscuhome.component';

describe('CoscuhomeComponent', () => {
  let component: CoscuhomeComponent;
  let fixture: ComponentFixture<CoscuhomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoscuhomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoscuhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
