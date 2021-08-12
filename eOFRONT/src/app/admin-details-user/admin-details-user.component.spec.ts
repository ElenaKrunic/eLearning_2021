import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsUserComponent } from './admin-details-user.component';

describe('AdminDetailsUserComponent', () => {
  let component: AdminDetailsUserComponent;
  let fixture: ComponentFixture<AdminDetailsUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
