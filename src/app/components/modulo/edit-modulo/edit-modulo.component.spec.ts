import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditModuloComponent } from './edit-modulo.component';

describe('EditModuloComponent', () => {
  let component: EditModuloComponent;
  let fixture: ComponentFixture<EditModuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditModuloComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditModuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
