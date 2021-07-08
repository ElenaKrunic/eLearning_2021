import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddPreexamObligationTypeComponent } from './admin-add-preexam-obligation-type.component';

describe('AdminAddPreexamObligationTypeComponent', () => {
  let component: AdminAddPreexamObligationTypeComponent;
  let fixture: ComponentFixture<AdminAddPreexamObligationTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddPreexamObligationTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddPreexamObligationTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
