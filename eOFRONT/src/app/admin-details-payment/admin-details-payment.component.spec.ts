import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsPaymentComponent } from './admin-details-payment.component';

describe('AdminDetailsPaymentComponent', () => {
  let component: AdminDetailsPaymentComponent;
  let fixture: ComponentFixture<AdminDetailsPaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsPaymentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
