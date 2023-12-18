package br.cin.ufpe.paybalance.controllers;

import br.cin.ufpe.paybalance.models.Saldo;
import br.cin.ufpe.paybalance.services.SaldoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/saldo")
public class SaldoController {
    private final SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @PostMapping
    public ResponseEntity criarSaldo(@RequestBody Saldo saldo, UriComponentsBuilder builder){
        var aux = saldoService.criarSaldo(saldo);
        var uri = builder.path("saldo/{id}").buildAndExpand(saldo.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }
}
