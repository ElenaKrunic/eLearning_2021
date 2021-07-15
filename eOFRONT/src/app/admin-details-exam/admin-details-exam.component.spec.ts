import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsExamComponent } from './admin-details-exam.component';

describe('AdminDetailsExamComponent', () => {
  let component: AdminDetailsExamComponent;
  let fixture: ComponentFixture<AdminDetailsExamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsExamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
