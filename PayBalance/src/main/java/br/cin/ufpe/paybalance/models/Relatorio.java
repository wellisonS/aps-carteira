package br.cin.ufpe.paybalance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Relatorio {
    @Id
    @GeneratedValue // Função para o ID autoincrementar
    private Long id;
    @OneToMany
    private List<Saldo> listaSaldos;
    @OneToMany
    private List<Debito> listaDebitos;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

 }
