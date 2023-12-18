package br.cin.ufpe.paybalance.repositories;

import br.cin.ufpe.paybalance.models.Saldo;
import br.cin.ufpe.paybalance.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  SaldoRepository extends JpaRepository <Saldo,Long> {

    public Optional <Saldo> findSaldoByUsuario(Usuario usuario);

}
