import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AesCbcComponent } from './aes-cbc.component';

describe('AesCbcComponent', () => {
  let component: AesCbcComponent;
  let fixture: ComponentFixture<AesCbcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AesCbcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AesCbcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
