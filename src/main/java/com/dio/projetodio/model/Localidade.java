package com.dio.projetodio.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter // Lombok cria os metodos get
@Setter // Lombok cria os metodos set
@AllArgsConstructor // Lombok cria o construtor com todas as propriedades da classe
@NoArgsConstructor // Lombok cria o construtor sem argumentos
@EqualsAndHashCode // Lombok cria os metodos equals e hashCode
@Builder // util para testes do software
@Entity
public class Localidade {
    @Id
    private long id;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    private String descricao;
}
