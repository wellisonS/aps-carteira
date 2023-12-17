package br.cin.ufpe.paybalance.repositories;

import br.cin.ufpe.paybalance.models.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository <Saldo,Long> {

}
