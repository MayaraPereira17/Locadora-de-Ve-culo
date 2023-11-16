import { ComponentFixture, TestBed } from '@angular/core/testing';

import { veiculoComponent } from './veiculo.component';

describe('VeiculoComponent', () => {
  let component: veiculoComponent;
  let fixture: ComponentFixture<veiculoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ veiculoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(veiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
