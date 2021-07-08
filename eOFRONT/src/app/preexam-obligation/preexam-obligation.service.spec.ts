import { TestBed } from '@angular/core/testing';

import { PreexamObligationService } from './preexam-obligation.service';

describe('PreexamObligationService', () => {
  let service: PreexamObligationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PreexamObligationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
