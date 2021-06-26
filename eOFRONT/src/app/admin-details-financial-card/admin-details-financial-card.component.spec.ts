import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsFinancialCardComponent } from './admin-details-financial-card.component';

describe('AdminDetailsFinancialCardComponent', () => {
  let component: AdminDetailsFinancialCardComponent;
  let fixture: ComponentFixture<AdminDetailsFinancialCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsFinancialCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsFinancialCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
