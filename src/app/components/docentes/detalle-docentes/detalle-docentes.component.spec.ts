import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleDocentesComponent } from './detalle-docentes.component';

describe('DetalleDocentesComponent', () => {
  let component: DetalleDocentesComponent;
  let fixture: ComponentFixture<DetalleDocentesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetalleDocentesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetalleDocentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
