import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListCourseComponent } from './admin-list-course.component';

describe('AdminListCourseComponent', () => {
  let component: AdminListCourseComponent;
  let fixture: ComponentFixture<AdminListCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
