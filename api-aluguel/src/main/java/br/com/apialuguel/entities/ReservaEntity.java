package br.com.apialuguel.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table(name = "tb_reserva")
public class ReservaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private long id;

    @Column(name = "data_inicio", updatable = true)
    private LocalDate data_inicio;

    @Column(name = "data_fim", updatable = true)
    private LocalDate data_fim;

    @Column(name = "status", updatable = true)
    private Integer status_reserva;

    @Column(name = "valor", updatable = true)
    private Double valor;

    @Column(name = "fk_veiculo", updatable = true)
    private Long fk_veiculo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public Integer getStatus_reserva() {
        return status_reserva;
    }

    public void setStatus_reserva(Integer status_reserva) {
        this.status_reserva = status_reserva;
    }

    public Long getFk_veiculo() {
        return fk_veiculo;
    }

    public void setFk_veiculo(Long fk_veiculo) {
        this.fk_veiculo = fk_veiculo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}


