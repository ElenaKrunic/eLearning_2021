import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancialcardStudentComponent } from './financialcard-student.component';

describe('FinancialcardStudentComponent', () => {
  let component: FinancialcardStudentComponent;
  let fixture: ComponentFixture<FinancialcardStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinancialcardStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancialcardStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
