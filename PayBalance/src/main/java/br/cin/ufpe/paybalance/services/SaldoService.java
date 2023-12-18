package br.cin.ufpe.paybalance.services;

import br.cin.ufpe.paybalance.models.Saldo;
import br.cin.ufpe.paybalance.models.observer.EventoSaldoAtualizado;
import br.cin.ufpe.paybalance.repositories.RelatorioRepository;
import br.cin.ufpe.paybalance.repositories.SaldoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SaldoService {
    private final SaldoRepository saldoRepository;

    private final ApplicationEventPublisher eventPublisher;

    public SaldoService(SaldoRepository saldoRepository, ApplicationEventPublisher eventPublisher) {
        this.saldoRepository = saldoRepository;
        this.eventPublisher = eventPublisher;
    }


    public Saldo criarSaldo(Saldo saldo){
        var auxSaldo = saldoRepository.findSaldoByUsuario(saldo.getUsuario());
        if (auxSaldo.isEmpty()){

         return new Saldo(null,saldo.getValor(),saldo.getData(),saldo.getUsuario());
        }
        auxSaldo.get().setValor(saldo.getValor());
        auxSaldo.get().setData(saldo.getData());

        eventPublisher.publishEvent(new EventoSaldoAtualizado(this,auxSaldo.get()));

        return saldoRepository.save(auxSaldo.get());

    }


}
