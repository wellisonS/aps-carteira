package br.cin.ufpe.paybalance.controllers;

import br.cin.ufpe.paybalance.models.Usuario;
import br.cin.ufpe.paybalance.services.RelatorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }
    @GetMapping
    public ResponseEntity buscarTodosRelatorios(Usuario usuario){
        return ResponseEntity.ok(relatorioService.findRelatorioByUsuario(usuario));
    }
}
