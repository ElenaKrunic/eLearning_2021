import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreexamObligationComponent } from './preexam-obligation.component';

describe('PreexamObligationComponent', () => {
  let component: PreexamObligationComponent;
  let fixture: ComponentFixture<PreexamObligationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreexamObligationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreexamObligationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
