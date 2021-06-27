import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListPreexamObligationStatusComponent } from './admin-list-preexam-obligation-status.component';

describe('AdminListPreexamObligationStatusComponent', () => {
  let component: AdminListPreexamObligationStatusComponent;
  let fixture: ComponentFixture<AdminListPreexamObligationStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListPreexamObligationStatusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListPreexamObligationStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
