import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsStudentComponent } from './admin-details-student.component';

describe('AdminDetailsStudentComponent', () => {
  let component: AdminDetailsStudentComponent;
  let fixture: ComponentFixture<AdminDetailsStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
