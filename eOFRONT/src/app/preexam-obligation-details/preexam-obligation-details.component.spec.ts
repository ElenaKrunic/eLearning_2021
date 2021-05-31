import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreexamObligationDetailsComponent } from './preexam-obligation-details.component';

describe('PreexamObligationDetailsComponent', () => {
  let component: PreexamObligationDetailsComponent;
  let fixture: ComponentFixture<PreexamObligationDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreexamObligationDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreexamObligationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
