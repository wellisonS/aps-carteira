package br.cin.ufpe.paybalance.services;

import br.cin.ufpe.paybalance.models.Debito;
import br.cin.ufpe.paybalance.repositories.DebitoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebitoService {
    private final DebitoRepository debitoRepository;


    public DebitoService(DebitoRepository debitoRepository) {
        this.debitoRepository = debitoRepository;
    }

    public Debito cadastroDebito (Debito debito){
        return debitoRepository.save(debito);
    }

    public boolean existeDebito(Long id) {
        return debitoRepository.existsById(id);
    }

    public Debito buscarDebito(Long id){
        return debitoRepository.findById(id).orElseThrow(()->new RuntimeException("Este debito não existe em nossos sistema. Por favor, verifique o id."));
    }

    public List<Debito> buscarTodosDebitos (){
        return debitoRepository.findAll();
    }

    public Debito atualizarDebito (Long id, Debito debito){
        var aux = debitoRepository.findById(id);

        if (aux.isPresent()) {
            if (debito.getValor() != null){
                aux.get().setValor(debito.getValor());
            }
            if (debito.getData() != null) {
                aux.get().setData(debito.getData());
            }

            if (debito.getTitulo() != null){
                aux.get().setTitulo(debito.getTitulo());
            }
        }
        return debitoRepository.save(debito);
    }

    public void removerDebito(Long id){
        debitoRepository.deleteById(id);
    }
}
