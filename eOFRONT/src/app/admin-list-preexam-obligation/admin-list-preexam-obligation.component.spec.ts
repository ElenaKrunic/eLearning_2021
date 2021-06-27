import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListPreexamObligationComponent } from './admin-list-preexam-obligation.component';

describe('AdminListPreexamObligationComponent', () => {
  let component: AdminListPreexamObligationComponent;
  let fixture: ComponentFixture<AdminListPreexamObligationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListPreexamObligationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminListPreexamObligationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
