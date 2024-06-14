import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaDocentesComponent } from './materia-docentes.component';

describe('MateriaDocentesComponent', () => {
  let component: MateriaDocentesComponent;
  let fixture: ComponentFixture<MateriaDocentesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MateriaDocentesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MateriaDocentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
