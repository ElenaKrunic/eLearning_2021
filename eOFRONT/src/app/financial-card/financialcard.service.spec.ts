import { TestBed } from '@angular/core/testing';

import { FinancialcardService } from './financialcard.service';

describe('FinancialcardService', () => {
  let service: FinancialcardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FinancialcardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
