import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerDocenteComponent } from './ver-docente.component';

describe('VerDocenteComponent', () => {
  let component: VerDocenteComponent;
  let fixture: ComponentFixture<VerDocenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VerDocenteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerDocenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
