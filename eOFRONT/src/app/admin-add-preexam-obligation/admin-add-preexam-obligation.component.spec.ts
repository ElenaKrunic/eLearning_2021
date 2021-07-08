import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddPreexamObligationComponent } from './admin-add-preexam-obligation.component';

describe('AdminAddPreexamObligationComponent', () => {
  let component: AdminAddPreexamObligationComponent;
  let fixture: ComponentFixture<AdminAddPreexamObligationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddPreexamObligationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddPreexamObligationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
