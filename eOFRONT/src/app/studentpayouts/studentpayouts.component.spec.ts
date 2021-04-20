import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentpayoutsComponent } from './studentpayouts.component';

describe('StudentpayoutsComponent', () => {
  let component: StudentpayoutsComponent;
  let fixture: ComponentFixture<StudentpayoutsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentpayoutsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentpayoutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
