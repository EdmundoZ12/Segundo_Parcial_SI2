import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LicenciasComponent } from './licencias.component';

describe('LicenciasComponent', () => {
  let component: LicenciasComponent;
  let fixture: ComponentFixture<LicenciasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LicenciasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LicenciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
