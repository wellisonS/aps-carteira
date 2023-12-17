package br.cin.ufpe.paybalance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Saldo {
    @Id
    @GeneratedValue // Função para o ID autoincrementar
    private Long id;
    private BigDecimal valor;
    @Temporal(TemporalType.DATE)
    private LocalDate data;
}
