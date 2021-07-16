import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListExamComponent } from './admin-list-exam.component';

describe('AdminListExamComponent', () => {
  let component: AdminListExamComponent;
  let fixture: ComponentFixture<AdminListExamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListExamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
