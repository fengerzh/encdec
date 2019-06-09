import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AesEcbComponent } from './aes-ecb.component';

describe('AesEcbComponent', () => {
  let component: AesEcbComponent;
  let fixture: ComponentFixture<AesEcbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AesEcbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AesEcbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
