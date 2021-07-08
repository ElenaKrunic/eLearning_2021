import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddFinancialCardComponent } from './admin-add-financial-card.component';

describe('AdminAddFinancialCardComponent', () => {
  let component: AdminAddFinancialCardComponent;
  let fixture: ComponentFixture<AdminAddFinancialCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddFinancialCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddFinancialCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
