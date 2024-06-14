import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VarMateriaDocenteComponent } from './var-materia-docente.component';

describe('VarMateriaDocenteComponent', () => {
  let component: VarMateriaDocenteComponent;
  let fixture: ComponentFixture<VarMateriaDocenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VarMateriaDocenteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VarMateriaDocenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
