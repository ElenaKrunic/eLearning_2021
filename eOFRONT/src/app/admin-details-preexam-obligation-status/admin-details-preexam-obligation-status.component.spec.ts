import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsPreexamObligationStatusComponent } from './admin-details-preexam-obligation-status.component';

describe('AdminDetailsPreexamObligationStatusComponent', () => {
  let component: AdminDetailsPreexamObligationStatusComponent;
  let fixture: ComponentFixture<AdminDetailsPreexamObligationStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsPreexamObligationStatusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsPreexamObligationStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
