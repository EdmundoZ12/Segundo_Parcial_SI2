import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexAreaComponent } from './index-area.component';

describe('IndexAreaComponent', () => {
  let component: IndexAreaComponent;
  let fixture: ComponentFixture<IndexAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndexAreaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndexAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});