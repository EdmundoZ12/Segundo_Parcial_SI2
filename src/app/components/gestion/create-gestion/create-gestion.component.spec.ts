import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateGestionComponent } from './create-gestion.component';

describe('CreateGestionComponent', () => {
  let component: CreateGestionComponent;
  let fixture: ComponentFixture<CreateGestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateGestionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateGestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
