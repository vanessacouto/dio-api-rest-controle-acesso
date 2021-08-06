package com.dio.projetodio.repository;

import com.dio.projetodio.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ao estender de JpaRepository, já teremos nossos metodos de CRUD implementados
@Repository //anotamos as classes repository com essa annotation para o Spring
public interface JornadaRepository extends JpaRepository<JornadaTrabalho, Long> {
    //nessas classes Repository, somente vai ter a responsabilidade de persistir os dados
    // (uma vez esses dados tratados pelas classes Service)
}
