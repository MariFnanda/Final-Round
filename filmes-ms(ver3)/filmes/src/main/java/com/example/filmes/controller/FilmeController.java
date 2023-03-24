package com.example.filmes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.filmes.service.FilmeService;
import com.example.filmes.shared.FilmeDto;
import com.example.filmes.shared.FilmesDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/catalogo")
public class FilmeController {
    @Autowired
    private FilmeService servico;

    @PostMapping
    public ResponseEntity<FilmesDto> cadastrarFilme(@RequestBody @Valid FilmesDto filme){
        return new ResponseEntity<>(servico.cadastrar(filme), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FilmesDto>> obterCatalogo(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
  public ResponseEntity<FilmeDto> obterFilme(@PathVariable String id) {
    Optional<FilmeDto> retorno = servico.obterPorId(id);

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFilme(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{id}")
  public ResponseEntity<FilmesDto> atualizarPizza(@PathVariable String id, @RequestBody FilmesDto filme){
    Optional<FilmesDto> retorno = servico.atualizarPorId(id, filme); 

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }   
  }

  @GetMapping("/porta")
  public String obterPorta(@Value("${local.server.port}") String porta){
    return "A instância que respondeu a requisição está rodando na porta" + porta;
  }
}
