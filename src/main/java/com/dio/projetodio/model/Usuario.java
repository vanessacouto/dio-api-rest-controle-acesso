package com.dio.projetodio.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter // Lombok cria os metodos get
@Setter // Lombok cria os metodos set
@AllArgsConstructor // Lombok cria o construtor com todas as propriedades da classe
@NoArgsConstructor // Lombok cria o construtor sem argumentos
@EqualsAndHashCode // Lombok cria os metodos equals e hashCode
@Builder // util para testes do software
@Entity
@Audited
public class Usuario {
    @Id
    private Long id;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    private String nome;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private  JornadaTrabalho jornadaTrabalho;

    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;
}
