import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexGestionComponent } from './index-gestion.component';

describe('IndexGestionComponent', () => {
  let component: IndexGestionComponent;
  let fixture: ComponentFixture<IndexGestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndexGestionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndexGestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
