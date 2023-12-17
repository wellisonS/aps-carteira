package br.cin.ufpe.paybalance.repositories;

import br.cin.ufpe.paybalance.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario,String> {

}
