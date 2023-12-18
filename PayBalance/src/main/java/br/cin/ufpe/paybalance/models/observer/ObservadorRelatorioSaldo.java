package br.cin.ufpe.paybalance.models.observer;

import br.cin.ufpe.paybalance.models.Relatorio;
import br.cin.ufpe.paybalance.models.Saldo;
import br.cin.ufpe.paybalance.services.RelatorioService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ObservadorRelatorioSaldo implements ApplicationListener<EventoSaldoAtualizado> {
   private final RelatorioService relatorioService;

    public ObservadorRelatorioSaldo(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @Override
    public void onApplicationEvent (EventoSaldoAtualizado e){
        Saldo saldo = e.getSaldo();
        var auxRelatorio = relatorioService.findRelatorioByUsuario(saldo.getUsuario());
        if (auxRelatorio.isEmpty()){

           auxRelatorio = java.util.Optional.ofNullable(relatorioService.criarRelatorio(new Relatorio(null, new ArrayList<>(), new ArrayList<>(), saldo.getUsuario())));
        }

        auxRelatorio.get().getListaSaldos().add(new Saldo(null,saldo.getValor(), saldo.getData(),saldo.getUsuario()));



    }
}
