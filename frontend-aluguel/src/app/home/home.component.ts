import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  title:string = 'reservaveiculo';

  valor:number = 0;

  marca:string = "";
  modelo:string = "";
  cor:string = "";
  placa: string = "";
  anoFabricacao = "";

  indexSelecionado:number = 0;
  editarVeiculo = false;

  Veiculo = [{
    marca: "fiat 1",
    modelo: "uno",
    cor: "preto",
    placa: "AAA 114 5",
    anoFabricacao:"2005"
 
  },
  {
    marca: "fiat 2",
    modelo: "uno",
    cor: "preto",
    placa: "AAA 114 5",
    anoFabricacao:"2005"
  },
  {
    marca: "fiat 3",
    modelo: "uno",
    cor: "preto",
    placa: "AAA 114 5",
    anoFabricacao:"2005"
  }]

  adicionaUm(){
    this.valor++;
  }

  adicionaVeiculo(){
    if(this.marca != "" && this.modelo != "" && this.cor !='' && this.placa !='' && this.anoFabricacao !=''){
      this.Veiculo.push({
        marca: this.marca,
        modelo: this.modelo,
        cor: this.cor,
        placa: this.placa,
        anoFabricacao: this.anoFabricacao,
      });
      this.limparDados();
    } else {
      alert("Não pode deixar os campos em branco,por favor preencha");
    }
  }

  removerVeiculo(i:number){
    this.Veiculo.splice(i,1);
  }

  alterarVeiculo(i:number){
    this.editarVeiculo = true;
    this.marca = this.Veiculo[i].marca;
    this.modelo = this.Veiculo[i].modelo;
    this.cor = this.Veiculo[i].cor;
    this.placa = this.Veiculo[i].placa;
    this.anoFabricacao = this.Veiculo[i].anoFabricacao;
    this.indexSelecionado = i;
  }

  efetuarAlteracaoDoVeiculo(){
    this.Veiculo[this.indexSelecionado].marca = this.marca;
    this.Veiculo[this.indexSelecionado].modelo = this.modelo;
    this.Veiculo[this.indexSelecionado].cor = this.cor;
    this.Veiculo[this.indexSelecionado].placa = this.modelo;
    this.Veiculo[this.indexSelecionado].anoFabricacao = this.anoFabricacao;
   
    this.limparDados();
  }

  limparDados(){
    this.editarVeiculo = false;
    this.marca = "";
    this.modelo = "";
    this.cor = "";
    this.placa = "";
    this.anoFabricacao = "";
    
    this.indexSelecionado = 0;
  }
}
