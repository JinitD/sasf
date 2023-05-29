import { TestBed } from '@angular/core/testing';

import { IsExpiredGuard } from './is-expired.guard';

describe('IsExpiredGuard', () => {
  let guard: IsExpiredGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(IsExpiredGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
