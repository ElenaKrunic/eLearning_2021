import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExamPeriodComponent } from './admin-exam-period.component';

describe('AdminExamPeriodComponent', () => {
  let component: AdminExamPeriodComponent;
  let fixture: ComponentFixture<AdminExamPeriodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminExamPeriodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminExamPeriodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
