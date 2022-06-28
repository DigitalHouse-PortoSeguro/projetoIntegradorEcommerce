import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LivroCadastroComponent } from './livro-cadastro.component';

describe('LivroCadastroComponent', () => {
  let component: LivroCadastroComponent;
  let fixture: ComponentFixture<LivroCadastroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LivroCadastroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LivroCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
