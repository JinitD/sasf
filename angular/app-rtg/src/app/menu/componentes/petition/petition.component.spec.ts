import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetitionComponent } from './petition.component';

describe('PetitionComponent', () => {
  let component: PetitionComponent;
  let fixture: ComponentFixture<PetitionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PetitionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PetitionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
