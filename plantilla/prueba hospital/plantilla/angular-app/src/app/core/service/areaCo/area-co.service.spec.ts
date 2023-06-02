import { TestBed } from '@angular/core/testing';

import { AreaCoService } from './area-co.service';

describe('AreaCoService', () => {
  let service: AreaCoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AreaCoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
