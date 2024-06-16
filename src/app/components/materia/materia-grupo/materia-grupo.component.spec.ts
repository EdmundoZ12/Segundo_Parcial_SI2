import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaGrupoComponent } from './materia-grupo.component';

describe('MateriaGrupoComponent', () => {
  let component: MateriaGrupoComponent;
  let fixture: ComponentFixture<MateriaGrupoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MateriaGrupoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MateriaGrupoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
