import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexGrupoComponent } from './index-grupo.component';

describe('IndexGrupoComponent', () => {
  let component: IndexGrupoComponent;
  let fixture: ComponentFixture<IndexGrupoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndexGrupoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndexGrupoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
