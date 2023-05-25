import { TestBed } from '@angular/core/testing';

import { ReclusoService } from './recluso.service';

describe('ReclusoService', () => {
  let service: ReclusoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReclusoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
