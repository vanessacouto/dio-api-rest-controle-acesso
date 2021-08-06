package com.dio.projetodio.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class BancoHoras {
    @EqualsAndHashCode
    @Embeddable
    @Getter
    @Setter
    public  class BancoHorasId implements Serializable {
        private long idBancoHoras;
        private long idMovimentacao;
        private long idUsuario;
    }
    @EmbeddedId
    private BancoHorasId bancoHorasId;

    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
