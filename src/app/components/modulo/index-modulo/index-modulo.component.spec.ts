import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexModuloComponent } from './index-modulo.component';

describe('IndexModuloComponent', () => {
  let component: IndexModuloComponent;
  let fixture: ComponentFixture<IndexModuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndexModuloComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndexModuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
