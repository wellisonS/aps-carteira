package br.cin.ufpe.paybalance.services;

import br.cin.ufpe.paybalance.models.Usuario;
import br.cin.ufpe.paybalance.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Função Inserir Usuário
    public Usuario cadastroUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public boolean existeUsuario (String login){
        return  usuarioRepository.existsById(login);
    }

    public Usuario buscarUsuario (String login) {
        return usuarioRepository.findById(login).orElseThrow(()->new RuntimeException("Este usuário não existe em nossos sistema. Por favor, verifique o login."));
    }

    public List<Usuario> buscarTodos (){
        return usuarioRepository.findAll();
    }

    public Usuario atualizaUsuario (String login, Usuario usuario){
        var aux = usuarioRepository.findById(login);
        if (aux.isPresent()){
            if (usuario.getSenha() != null){
                aux.get().setSenha(usuario.getSenha());
            }
            if (usuario.getNome() != null){
                aux.get().setNome(usuario.getNome());
            }



        }
        return usuarioRepository.save(usuario);
    }

    public void removerUsuario( String login){
        usuarioRepository.deleteById(login);
    }
}
