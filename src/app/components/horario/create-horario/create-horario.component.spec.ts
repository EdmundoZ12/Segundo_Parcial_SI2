import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateHorarioComponent } from './create-horario.component';

describe('CreateHorarioComponent', () => {
  let component: CreateHorarioComponent;
  let fixture: ComponentFixture<CreateHorarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateHorarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateHorarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
