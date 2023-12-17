package br.cin.ufpe.paybalance.controllers;

import br.cin.ufpe.paybalance.models.Usuario;
import br.cin.ufpe.paybalance.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity criar(@RequestBody Usuario usuario) {
        var aux = usuarioService.cadastroUsuario(usuario);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity buscarTodos(){

        return ResponseEntity.ok(usuarioService.buscarTodos());
    }
    @GetMapping("/{login}")
    public ResponseEntity buscarUsuario(@PathVariable String login){

        return ResponseEntity.ok(usuarioService.buscarUsuario(login));
    }

    @DeleteMapping("/{login}")
    public ResponseEntity deletarUsuario (@PathVariable String login){

        usuarioService.removerUsuario(login);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{login}")

    public ResponseEntity atualizar (@RequestBody Usuario usuario, @PathVariable String login){

        return ResponseEntity.ok(usuarioService.atualizaUsuario(login,usuario));
    }
}
