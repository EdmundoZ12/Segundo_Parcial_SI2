import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateModuloComponent } from './create-modulo.component';

describe('CreateModuloComponent', () => {
  let component: CreateModuloComponent;
  let fixture: ComponentFixture<CreateModuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateModuloComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateModuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
