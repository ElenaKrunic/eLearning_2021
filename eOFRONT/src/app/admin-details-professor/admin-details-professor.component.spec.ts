import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsProfessorComponent } from './admin-details-professor.component';

describe('AdminDetailsProfessorComponent', () => {
  let component: AdminDetailsProfessorComponent;
  let fixture: ComponentFixture<AdminDetailsProfessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsProfessorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
