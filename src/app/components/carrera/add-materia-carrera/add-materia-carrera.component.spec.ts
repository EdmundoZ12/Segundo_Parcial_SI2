import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMateriaCarreraComponent } from './add-materia-carrera.component';

describe('AddMateriaCarreraComponent', () => {
  let component: AddMateriaCarreraComponent;
  let fixture: ComponentFixture<AddMateriaCarreraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddMateriaCarreraComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddMateriaCarreraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
