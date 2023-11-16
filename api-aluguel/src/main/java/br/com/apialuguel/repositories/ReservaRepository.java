package br.com.apialuguel.repositories;


import br.com.apialuguel.entities.ReservaEntity;
import br.com.apialuguel.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

    Optional<ReservaEntity> findVeiculoEntitiesById(Long id);

    @Query("SELECT r FROM ReservaEntity r WHERE r.fk_veiculo = :fk_veiculo AND r.data_inicio <= :data_inicio AND r.data_fim >= :data_fim")
    List<ReservaEntity> findByVeiculoPorData(Long fk_veiculo, LocalDate data_inicio, LocalDate data_fim);

    @Query("SELECT r FROM ReservaEntity r WHERE r.fk_veiculo = :fk_veiculo")
    Optional<ReservaEntity> findByReservaVeiculo(Long fk_veiculo);

    @Modifying
    @Query("DELETE FROM ReservaEntity r where r.fk_veiculo = :id")
    void deleteReservaPorVeiculo(Long id);
}

