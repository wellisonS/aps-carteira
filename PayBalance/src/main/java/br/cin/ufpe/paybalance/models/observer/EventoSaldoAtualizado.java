package br.cin.ufpe.paybalance.models.observer;

import br.cin.ufpe.paybalance.models.Saldo;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventoSaldoAtualizado extends ApplicationEvent {

    private Saldo saldo;

    public EventoSaldoAtualizado(Object source, Saldo saldo) {
        super(source);
        this.saldo = saldo;
    }


}
