import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { VeiculoService } from "./veiculo.service";
import { TestBed } from "@angular/core/testing";
import{ Veiculo } from "./veiculo";

describe('VeiculoService', () => {
    let VeiculoService: VeiculoService; 
    let httpController: HttpTestingController;   
  
    beforeEach(async () => {
        TestBed.configureTestingModule({
            imports:[HttpClientTestingModule],
            providers: [VeiculoService]
        });
        VeiculoService = TestBed.inject(VeiculoService);
      httpController = TestBed.inject(HttpTestingController);
    });

    afterEach(() => {
        httpController.verify();
    })

    it('should retrive a vehicle', () => {
        const mockRespostaVeiculo:Veiculo[] = [{
            id: 1,
            marca: "teste",
            modelo: "uno",
            cor: "teste",
            placa: "AAA 1A11e",
            anoFabricacao: 2024,
            checked: false
          }]
        VeiculoService.recuperarVeiculos().subscribe(
            (resposta) => {
                expect(resposta).toEqual(mockRespostaVeiculo);
            }
        );

        const url = "http://localhost:8080/veiculo";
        const requisicao = httpController.expectOne(url);
        expect(requisicao.request.method).toEqual('GET');
        requisicao.flush(mockRespostaVeiculo);
    });

    it('should retrive a vehicle', () => {
        const mockRespostaVeiculo:Veiculo = {
            id: 1,
            marca: "teste",
            modelo: "Uno",
            cor: "preto",
            placa: "AAA 1A11e",
            anoFabricacao: 2024,
            checked: false
          }
        VeiculoService.salvarVeiculo(mockRespostaVeiculo).subscribe(
            (resposta) => {
                expect(resposta).toEqual(mockRespostaVeiculo);
            }
        );

        const url = "http://localhost:8080/veiculo/criar";
        const requisicao = httpController.expectOne(url);
        expect(requisicao.request.method).toEqual('POST');
        requisicao.flush(mockRespostaVeiculo);
    });
});