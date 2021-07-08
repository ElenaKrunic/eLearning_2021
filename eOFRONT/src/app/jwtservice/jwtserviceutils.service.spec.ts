import { TestBed } from '@angular/core/testing';

import { JwtserviceutilsService } from './jwtserviceutils.service';

describe('JwtserviceutilsService', () => {
  let service: JwtserviceutilsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtserviceutilsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
