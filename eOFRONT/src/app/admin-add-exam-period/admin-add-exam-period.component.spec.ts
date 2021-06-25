import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddExamPeriodComponent } from './admin-add-exam-period.component';

describe('AdminAddExamPeriodComponent', () => {
  let component: AdminAddExamPeriodComponent;
  let fixture: ComponentFixture<AdminAddExamPeriodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddExamPeriodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddExamPeriodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
