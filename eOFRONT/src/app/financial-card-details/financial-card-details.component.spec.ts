import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancialCardDetailsComponent } from './financial-card-details.component';

describe('FinancialCardDetailsComponent', () => {
  let component: FinancialCardDetailsComponent;
  let fixture: ComponentFixture<FinancialCardDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinancialCardDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancialCardDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
