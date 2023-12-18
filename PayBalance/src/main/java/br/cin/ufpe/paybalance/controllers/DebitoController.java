package br.cin.ufpe.paybalance.controllers;

import br.cin.ufpe.paybalance.services.DebitoService;
import br.cin.ufpe.paybalance.models.Debito;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/debito")
public class DebitoController {

    private final DebitoService debitoService;

    public DebitoController(DebitoService debitoService) {
        this.debitoService = debitoService;
    }

    @PostMapping
    public ResponseEntity criarDebito(@RequestBody Debito debito, UriComponentsBuilder builder){
        var aux = debitoService.cadastroDebito(debito);
        var uri = builder.path("debito/{id}").buildAndExpand(debito.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    @GetMapping
    public ResponseEntity buscarTodosDebitos(){
        return  ResponseEntity.ok(debitoService.buscarTodosDebitos());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarDebito(@PathVariable Long id){
        return ResponseEntity.ok(debitoService.buscarDebito(id));
    }

    @DeleteMapping
    public ResponseEntity deletarDebito (@PathVariable Long id){
        debitoService.removerDebito(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity atualizarDebito (@RequestBody Debito debito, @PathVariable Long id){
        return ResponseEntity.ok(debitoService.atualizarDebito(id,debito));
    }


}
