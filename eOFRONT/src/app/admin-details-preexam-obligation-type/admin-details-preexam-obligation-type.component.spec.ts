import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsPreexamObligationTypeComponent } from './admin-details-preexam-obligation-type.component';

describe('AdminDetailsPreexamObligationTypeComponent', () => {
  let component: AdminDetailsPreexamObligationTypeComponent;
  let fixture: ComponentFixture<AdminDetailsPreexamObligationTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsPreexamObligationTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsPreexamObligationTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
