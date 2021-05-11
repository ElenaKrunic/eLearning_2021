import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPreexamObligationComponent } from './admin-preexam-obligation.component';

describe('AdminPreexamObligationComponent', () => {
  let component: AdminPreexamObligationComponent;
  let fixture: ComponentFixture<AdminPreexamObligationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminPreexamObligationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPreexamObligationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
