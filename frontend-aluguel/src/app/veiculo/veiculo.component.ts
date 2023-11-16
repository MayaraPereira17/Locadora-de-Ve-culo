import { Component, OnInit } from '@angular/core';
import { Veiculo } from './veiculo';
import { VeiculoService } from './veiculo.service';

@Component({
  selector: 'app-veiculo',
  templateUrl: './veiculo.component.html',
  styleUrls: ['./veiculo.component.scss']
})
export class VeiculoComponent implements OnInit{

  constructor(private VeiculoService:VeiculoService){};

  veiculo: Veiculo = new Veiculo;

  veiculos:Veiculo[] = [];

  carregando:boolean = true;

  ngOnInit(): void {
    this.consultaVeiculo();
  }

  consultaVeiculo(): void{
    this.carregando = true;
    this.VeiculoService.recuperarVeiculos().subscribe(
      resposta => {
        this.veiculos = resposta;
        this.limpar();
      },
      erro => {
        this.carregando = false;
        alert("Erro em procurar um veiculo");
        console.log(erro);
      }
    )
  }

  salvaVeiculo(): void{
    this.carregando = true;
    this.VeiculoService.salvarVeiculo(this.veiculo).subscribe(
      resposta => {
        alert("Veiculo inserido com sucesso!");
        this.limpar();
        this.consultaVeiculo();
      },
      erro => {
        this.carregando = false;
        alert("Erro ao criar um Veiculo");
        console.log(erro);
      }
    )
  }

  apagarVeiculo(id:number | null, marca:string | null): void{
    this.carregando = true;
    if(id != null && marca != null){
      this.VeiculoService.apagarVeiculo(id, marca).subscribe(
        resposta => {
          alert("Veiculo apagado com sucesso!");
          this.limpar();
          this.consultaVeiculo();
        },
        erro => {
          this.carregando = false;
          alert("Erro ao apagar um veículo!");
          console.log(erro);
        }
      )
    }
  }

  alterarVeiculo(veiculo:Veiculo): void{
    this.veiculo = veiculo;
  }

  efetuarAlteracaoVeiculo(): void{
    this.carregando = true;
    this.VeiculoService.alterarVeiculo(this.veiculo).subscribe(
      resposta => {
        alert("veiculo Alterado com sucesso alterado com sucesso!");
        this.limpar();
        this.consultaVeiculo();
      },
      erro => {
        this.carregando = false;
        alert("Erro ao alterar informações do veículo!");
        console.log(erro);
      }
    )
  }

  limpar(): void{
    this.carregando = false;
    this.veiculo = new Veiculo;
  }

 /*  validaNumerosAnoFabricacao(): void{
    const valorAux = this.veiculo.anoFabricacao?.toString().replace(/[a-zA-Z]/g,"");
    if(valorAux != undefined && valorAux != "" && valorAux != null){
      this.veiculos.anoFabricacao = parseInt(valorAux)
    } else {
      this.veiculo.anoFabricacao = null;
    }
  } */

 
  //validando a placa
  /* validaPlaca(): void{
    const valorAux = this.veiculo.placa?.toString().replace(/^[a-zA-Z]{3}[0-9]{4}$/,"");
    if(valorAux != undefined && valorAux != "" && valorAux != null){
      this.veiculos.placa = parseInt(valorAux)
    } else {
     console.log(error);
    }
  } */

  apagarVarios(): void{
    this.carregando = true;
    console.log(this.veiculos);
    this.veiculos.forEach(veiculo => {
      if(veiculo.checked != undefined && veiculo.checked){
        if(veiculo.id != null && veiculo.marca != null && veiculo.modelo != null && veiculo.cor != null  && veiculo.placa != null && veiculo.anoFabricacao  != null){
        this.VeiculoService.apagarVeiculo(veiculo.id,veiculo.marca).subscribe(
          resposta => {
            this.carregando = false;
            this.consultaVeiculo();
          },
          erro => {
            this.carregando = false;
            console.log(erro);
          }
        )
      }
    }
    });
    

  }
}
  

