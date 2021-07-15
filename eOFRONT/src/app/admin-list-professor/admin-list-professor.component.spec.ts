import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListProfessorComponent } from './admin-list-professor.component';

describe('AdminListProfessorComponent', () => {
  let component: AdminListProfessorComponent;
  let fixture: ComponentFixture<AdminListProfessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListProfessorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
