package br.com.apialuguel.controllers;

import br.com.apialuguel.entities.ReservaEntity;
import br.com.apialuguel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
public class ReservaController {


    @Autowired
    ReservaRepository reservaRepository;

    private HashMap<String, Object> retornoHasmap = new HashMap<>();

    @PostMapping("/criar")
    public ResponseEntity postCriarReserva(@RequestBody ReservaEntity novaReserva) {
        List<ReservaEntity> reservas_existentes = reservaRepository.findByVeiculoPorData(novaReserva.getFk_veiculo(),
                novaReserva.getData_inicio(), novaReserva.getData_fim());

        if (!reservas_existentes.isEmpty()) {
            retornoHasmap.put("message", "Este veículo já está reservado para as datas selecionadas");
            return ResponseEntity.status(200).body(retornoHasmap);
        } else {
            try {
                retornoHasmap.put("message", "Veículo reservado com suceso!");
                reservaRepository.save(novaReserva);
                return ResponseEntity.status(200).body(retornoHasmap);
            } catch (Exception e) {
                return ResponseEntity.status(500).build();
            }
        }
    }

    @GetMapping
    public ResponseEntity getAllReservas() {
        return ResponseEntity.status(200).body(reservaRepository.findAll());
    }

    @DeleteMapping("/cancelar/{id_veiculo}")
    public ResponseEntity deleteCancelarReserva(@PathVariable Long id_veiculo) {

        Optional<ReservaEntity> reserva_veiculo_existente = reservaRepository.findByReservaVeiculo(id_veiculo);

        if (!reserva_veiculo_existente.isPresent()) {
            retornoHasmap.put("message", "Este veículo não possui reservas!");
            return ResponseEntity.status(200).body(retornoHasmap);
        } else {
            try {
                reservaRepository.deleteReservaPorVeiculo(id_veiculo);
                retornoHasmap.put("message", "Reserva cancelada com sucesso");
                return ResponseEntity.status(200).body(retornoHasmap);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return ResponseEntity.status(500).build();
            }
        }
    }
}
