import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsExamPeriodComponent } from './admin-details-exam-period.component';

describe('AdminDetailsExamPeriodComponent', () => {
  let component: AdminDetailsExamPeriodComponent;
  let fixture: ComponentFixture<AdminDetailsExamPeriodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsExamPeriodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsExamPeriodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
