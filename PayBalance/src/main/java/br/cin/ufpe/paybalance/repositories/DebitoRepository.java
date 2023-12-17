package br.cin.ufpe.paybalance.repositories;

import br.cin.ufpe.paybalance.models.Debito;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DebitoRepository extends JpaRepository <Debito, Long> {
}
