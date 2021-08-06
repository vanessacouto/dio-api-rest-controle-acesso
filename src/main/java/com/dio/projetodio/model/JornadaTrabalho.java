package com.dio.projetodio.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter // Lombok cria os metodos get
@Setter // Lombok cria os metodos set
@AllArgsConstructor // Lombok cria o construtor com todas as propriedades da classe
@NoArgsConstructor // Lombok cria o construtor sem argumentos
@EqualsAndHashCode // Lombok cria os metodos equals e hashCode
@Builder // util para testes do software
//@Data // usando apenas essa annotation não precisaríamos de todas essas acima
@Entity
@Audited // auditoria do hibernate envers (com isso cria no banco uma tabela de auditoria, no caso, a "JORNADA_TRABALHO_AUD")
public class JornadaTrabalho {
    @Id
    @GeneratedValue // usado pela sequence do banco de dados
    private long id;

    private String descricao;

}
