package com.dio.projetodio.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter // Lombok cria os metodos get
@Setter // Lombok cria os metodos set
@AllArgsConstructor // Lombok cria o construtor com todas as propriedades da classe
@NoArgsConstructor // Lombok cria o construtor sem argumentos
@EqualsAndHashCode // Lombok cria os metodos equals e hashCode
@Builder // util para testes do software
@Entity
public class Movimentacao {

    // a chave da tabela Movimentacao é uma chave composta entre a chave primaria de
    // Movimentação com a chave primária de Usuário
    // Para o Spring saber que se trata de uma chave composta, utilizamo a annotation @Embeddable
    // Assim teremos um @EmbeddedId, ou seja, um "id embutido"
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public  class  MovimentacaoId implements Serializable {
        private long idMovimento;
        private long idUsuario;
    }
    @EmbeddedId
    private MovimentacaoId movimentacaoId;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;

    @ManyToOne
    private Ocorrencia ocorrencia;

    @ManyToOne
    private Calendario calendario;
}
