package br.cin.ufpe.paybalance.repositories;
import br.cin.ufpe.paybalance.models.Usuario;
import br.cin.ufpe.paybalance.models.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelatorioRepository extends JpaRepository <Relatorio,Long> {

    public Optional < Relatorio> findRelatorioByUsuario(Usuario usuario);
}
