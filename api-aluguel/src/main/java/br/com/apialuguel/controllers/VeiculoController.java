package br.com.apialuguel.controllers;

import br.com.apialuguel.entities.VeiculoEntity;
import br.com.apialuguel.repositories.VeiculoRepository;
import jakarta.websocket.server.PathParam;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@DynamicUpdate
@RequestMapping("veiculo")
public class VeiculoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    private HashMap<String, Object> retornoHasmap = new HashMap<>();
    public boolean isVeiculoExiste(String placa) {
        List<VeiculoEntity> retornoVeiculoByPlaca = veiculoRepository.findByPlaca(placa);
        return retornoVeiculoByPlaca.isEmpty();
    }

    @PostMapping("/criar")
    public ResponseEntity saveVeiculoEntity(@RequestBody VeiculoEntity novoVeiculo) {

        if (!isVeiculoExiste(novoVeiculo.getPlaca())) {
            retornoHasmap.put("message", "Este veículo já existe!");
            return ResponseEntity.status(200).body(retornoHasmap);
        }

        try {
            veiculoRepository.save(novoVeiculo);
            retornoHasmap.put("message", "Veículo cadastrado com sucesso!");
            return ResponseEntity.status(201).body(retornoHasmap);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity getVeiculoById(@PathVariable Long id) {

        Optional<VeiculoEntity> retorno = veiculoRepository.findById(id);

        if (retorno.isEmpty()) {
            retornoHasmap.put("message", "Veículo não existente!");
            return ResponseEntity.status(404).body(retornoHasmap);
        }

        return ResponseEntity.status(200).body(retorno);
    }

    @GetMapping()
    public ResponseEntity getAllVeiculos() {
        return ResponseEntity.status(200).body(veiculoRepository.findAll());
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity putVeiculo(@RequestBody VeiculoEntity veiculoAtualizado, @PathVariable Long id) {

        if (veiculoRepository.existsById(id)){

            Optional<VeiculoEntity> veiculo_atual = veiculoRepository.findById(id);

            veiculo_atual.get().setId(veiculoAtualizado.setId(id));
            veiculo_atual.get().setAnofabricacao(veiculoAtualizado.getAnofabricacao());
            veiculo_atual.get().setMarca(veiculoAtualizado.getMarca());
            veiculo_atual.get().setPlaca(veiculoAtualizado.getPlaca());
            veiculo_atual.get().setCor(veiculoAtualizado.getCor());
            veiculo_atual.get().setModelo(veiculoAtualizado.getModelo());

            retornoHasmap.put("message", "Veículo atualizado com sucesso!");
            veiculoRepository.save(veiculoAtualizado);
            return ResponseEntity.status(200).body(retornoHasmap);
        } else {
            retornoHasmap.put("message", "Veículo não existente!");
            return ResponseEntity.status(404).body(retornoHasmap);
        }
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity deleteVeiculo(@PathVariable Long id) {


        List<VeiculoEntity> veiculoPossuiReserva = veiculoRepository.buscarVeiculoReservas(id);

        if(!veiculoPossuiReserva.isEmpty()) {
            retornoHasmap.put("message", "Este veículo possui reservas, não será possível deletar!");
            return ResponseEntity.status(404).body(retornoHasmap);
        } else {
            if (!veiculoRepository.existsById(id)){
                retornoHasmap.put("message", "Veículo não existente!");
                return ResponseEntity.status(404).body(retornoHasmap);
            } else {
                try {
                    veiculoRepository.deleteById(id);
                    retornoHasmap.put("message", "Veículo deletado com sucesso!");
                    return ResponseEntity.status(200).body(retornoHasmap);
                } catch (Exception e) {
                    System.out.printf(e.getMessage());
                    return ResponseEntity.status(500).build();
                }
            }
        }

    }
}
