import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMateriaComponent } from './create-materia.component';

describe('CreateMateriaComponent', () => {
  let component: CreateMateriaComponent;
  let fixture: ComponentFixture<CreateMateriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateMateriaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateMateriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
