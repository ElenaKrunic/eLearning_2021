import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetailsDocumentComponent } from './admin-details-document.component';

describe('AdminDetailsDocumentComponent', () => {
  let component: AdminDetailsDocumentComponent;
  let fixture: ComponentFixture<AdminDetailsDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDetailsDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDetailsDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
