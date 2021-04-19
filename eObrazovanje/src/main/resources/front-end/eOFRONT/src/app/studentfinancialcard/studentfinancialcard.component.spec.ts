import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentfinancialcardComponent } from './studentfinancialcard.component';

describe('StudentfinancialcardComponent', () => {
  let component: StudentfinancialcardComponent;
  let fixture: ComponentFixture<StudentfinancialcardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentfinancialcardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentfinancialcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
