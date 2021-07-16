import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsCourseComponent } from './admin-details-course.component';

describe('AdminDetailsCourseComponent', () => {
  let component: AdminDetailsCourseComponent;
  let fixture: ComponentFixture<AdminDetailsCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
