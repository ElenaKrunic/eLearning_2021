import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListFinancialCardComponent } from './admin-list-financial-card.component';

describe('AdminListFinancialCardComponent', () => {
  let component: AdminListFinancialCardComponent;
  let fixture: ComponentFixture<AdminListFinancialCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListFinancialCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListFinancialCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
