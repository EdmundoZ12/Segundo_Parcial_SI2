import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexMateriaComponent } from './index-materia.component';

describe('IndexMateriaComponent', () => {
  let component: IndexMateriaComponent;
  let fixture: ComponentFixture<IndexMateriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndexMateriaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndexMateriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
