import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListExamPeriodComponent } from './admin-list-exam-period.component';

describe('AdminListExamPeriodComponent', () => {
  let component: AdminListExamPeriodComponent;
  let fixture: ComponentFixture<AdminListExamPeriodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListExamPeriodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListExamPeriodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
