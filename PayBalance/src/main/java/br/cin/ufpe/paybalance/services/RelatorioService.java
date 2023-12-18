package br.cin.ufpe.paybalance.services;

import br.cin.ufpe.paybalance.models.Relatorio;
import br.cin.ufpe.paybalance.models.Usuario;
import br.cin.ufpe.paybalance.repositories.RelatorioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelatorioService {
    private final RelatorioRepository relatorioRepository;

    public RelatorioService(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public Optional<Relatorio> findRelatorioByUsuario(Usuario usuario) {

        return relatorioRepository.findRelatorioByUsuario(usuario);
    }
    public Relatorio criarRelatorio (Relatorio relatorio){
        return relatorioRepository.save(relatorio);
    }
}
