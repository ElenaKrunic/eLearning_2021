import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFinancialCardComponent } from './admin-financial-card.component';

describe('AdminFinancialCardComponent', () => {
  let component: AdminFinancialCardComponent;
  let fixture: ComponentFixture<AdminFinancialCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFinancialCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFinancialCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
