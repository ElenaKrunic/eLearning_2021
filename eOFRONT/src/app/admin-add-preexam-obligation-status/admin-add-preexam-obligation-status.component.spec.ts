import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddPreexamObligationStatusComponent } from './admin-add-preexam-obligation-status.component';

describe('AdminAddPreexamObligationStatusComponent', () => {
  let component: AdminAddPreexamObligationStatusComponent;
  let fixture: ComponentFixture<AdminAddPreexamObligationStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddPreexamObligationStatusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddPreexamObligationStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
