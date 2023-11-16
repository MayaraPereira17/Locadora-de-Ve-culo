import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Veiculo } from './veiculo';

@Injectable({
    providedIn: 'root'
})
export class VeiculoService {
    constructor (private http:HttpClient){}

    // private url = "http://localhost:3000/veiculos";
    private url = "http://localhost:8080/veiculo";

    public recuperarVeiculos():Observable<Veiculo[]>{
        return this.http.get<any>(this.url);
    }

    public salvarVeiculo(Veiculo:Veiculo):Observable<any>{
        return this.http.post<Veiculo>(this.url+"/inserir", Veiculo);
    }

    public apagarVeiculo(id:number, marca:string):Observable<any>{
        return this.http.delete<Veiculo>(this.url+"?id="+id+"&marca="+marca);
    }

    public alterarVeiculo(veiculo:Veiculo):Observable<any>{
        return this.http.put<Veiculo>(this.url, veiculo);
    }
}