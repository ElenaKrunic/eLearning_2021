import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsPreexamObligationComponent } from './admin-details-preexam-obligation.component';

describe('AdminDetailsPreexamObligationComponent', () => {
  let component: AdminDetailsPreexamObligationComponent;
  let fixture: ComponentFixture<AdminDetailsPreexamObligationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsPreexamObligationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsPreexamObligationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
