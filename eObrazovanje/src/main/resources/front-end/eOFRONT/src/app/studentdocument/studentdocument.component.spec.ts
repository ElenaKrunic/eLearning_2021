import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentdocumentComponent } from './studentdocument.component';

describe('StudentdocumentComponent', () => {
  let component: StudentdocumentComponent;
  let fixture: ComponentFixture<StudentdocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentdocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentdocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
