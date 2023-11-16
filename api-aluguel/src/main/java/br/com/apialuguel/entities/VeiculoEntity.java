package br.com.apialuguel.entities;

import br.com.apialuguel.repositories.ReservaRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "tb_veiculo")
public class VeiculoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private long id;

    @Column(name = "modelo", updatable = true)
    private String modelo;

    @Column(name = "marca", updatable = true)
    private String marca;

    @Column(name = "placa", updatable = true)
    private String placa;

    @Column(name = "cor")
    private String cor;

    @Column(name = "anofabricacao", updatable = true)
    private Integer anofabricacao;

    public long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(Integer anofabricacao) {
        this.anofabricacao = anofabricacao;
    }
}
