import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentpreexamobligationsComponent } from './studentpreexamobligations.component';

describe('StudentpreexamobligationsComponent', () => {
  let component: StudentpreexamobligationsComponent;
  let fixture: ComponentFixture<StudentpreexamobligationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentpreexamobligationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentpreexamobligationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
