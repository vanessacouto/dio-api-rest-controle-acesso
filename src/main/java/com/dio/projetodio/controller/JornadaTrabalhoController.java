package com.dio.projetodio.controller;

import com.dio.projetodio.model.JornadaTrabalho;
import com.dio.projetodio.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController //se fizemos, por exemplo, um "get" solicitando algo, essa annotation já se encarrega de retornar
// isso em formato JSON
@RequestMapping("/jornada") //referencia ao nome do endpoint que chamara os recursos
public class JornadaTrabalhoController {

    //nessas classes Controller, ela é responsável por fazer uma "interface", recebendo as requisições

    @Autowired //podemos usar o Autowired assim ou via construtor como na classe "JornadaService"
    JornadaService jornadaService;

    @PostMapping // quando o cliente fizer uma requisição POST para o "/jornada", vai disparar esse método
    // e no corpo dessa requisição vai ter que mandar um JornadaTrabalho
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    // pega todas as jornadas do banco
    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();
    }

    // retorna uma Jornada de "id" especifico
    // Usamos o @PathVariable já que o "id" que vamos passar faz parte do caminho da nossa URL (também é possivel usar o @RequestParam
    // e passar essa "id" de outra maneira)
    // O "ResponseEntity" trata da resposta HTTP
    @GetMapping("/{idJornada}") // "idJornada" deve estar entre "chaves" { }
    public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        // usamos o "orElseThrow" para jogar uma exceção se não encontar a Jornada
        return  ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Jornada não encontrada!")));
    }

    // atualiza uma Jornada
    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    // deleta uma Jornada especifica
    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        try {
            jornadaService.deleteJornada(idJornada);
        } catch (Exception e) {
            System.out.println("Erro deletando Jornada: " + e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }
}
