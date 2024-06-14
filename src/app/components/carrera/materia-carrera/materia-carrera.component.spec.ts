import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaCarreraComponent } from './materia-carrera.component';

describe('MateriaCarreraComponent', () => {
  let component: MateriaCarreraComponent;
  let fixture: ComponentFixture<MateriaCarreraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MateriaCarreraComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MateriaCarreraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
