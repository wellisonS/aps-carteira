package br.cin.ufpe.paybalance.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id // chave primaria
    private String login;
    private String senha;
    private  String nome;
   // TODO Adicionar atributo para conta bancaria.
    private boolean contaBancaria;
}
