import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexHorarioComponent } from './index-horario.component';

describe('IndexHorarioComponent', () => {
  let component: IndexHorarioComponent;
  let fixture: ComponentFixture<IndexHorarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndexHorarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndexHorarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
