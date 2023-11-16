package br.com.apialuguel.repositories;

import br.com.apialuguel.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface  VeiculoRepository extends JpaRepository<VeiculoEntity, Integer> {

    @Query("select v from tb_veiculo as v where v.placa = :placa")
    List<VeiculoEntity> findByPlaca(String placa);

    Optional<VeiculoEntity> findById(Long id);

    Boolean existsById(Long id);
    @Transactional
    void deleteById(Long id);

    @Query("SELECT v FROM tb_veiculo v left join ReservaEntity as r on r.fk_veiculo = v.id")
    List<VeiculoEntity> buscarVeiculoReservas(Long id_veiculo);


}
