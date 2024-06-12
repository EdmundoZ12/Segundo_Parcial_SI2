import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexCarreraComponent } from './index-carrera.component';

describe('IndexCarreraComponent', () => {
  let component: IndexCarreraComponent;
  let fixture: ComponentFixture<IndexCarreraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndexCarreraComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndexCarreraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
