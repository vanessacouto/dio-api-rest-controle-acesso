package com.dio.projetodio.service;

import com.dio.projetodio.model.JornadaTrabalho;
import com.dio.projetodio.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //anotamos as classes service com essa annotation
public class JornadaService {
    //nessas classes Service, implementamos nossas classes de negócio, nossa REGRA DE NEGÓCIO

    // hoje o padrão é o @Autowired via construtor
    //@Autowired // o Spring fará a inicialização dessa dependencia, assim não precisamos inicializa-lo quando
    // formos usar esse repository
    //JornadaRepository jornadaRepository;


    JornadaRepository jornadaRepository;
    //o padrão @Autowired por meio de construtor
    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    // cria uma nova Jornada
    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
        //esse mesmo método "save" faz a ação de atualizar
        return jornadaRepository.save(jornadaTrabalho);
    }

    // pega todas as jornadas do banco
    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }

    // estamos usando o "Optional"
    public Optional<JornadaTrabalho> getById(Long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    // atualiza uma Jornada (método igual ao de criar uma Jornada)
    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    // deletar uma Jornada específica
    public void deleteJornada(Long idJornada) {
        jornadaRepository.deleteById(idJornada);
    }

}
