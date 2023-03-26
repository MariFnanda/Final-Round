package com.example.ingressos.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ingressos.shared.IngressoCompletoDto;
import com.example.ingressos.shared.IngressoDto;
import com.example.ingressos.service.IngressoService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/ingresso")
public class IngressosController {
    
    @Autowired
    private IngressoService servico;

    @PostMapping
    public ResponseEntity<IngressoCompletoDto> cadastrarIngresso(@RequestBody @Valid IngressoCompletoDto ingresso)
    {
        return new ResponseEntity<>(servico.cadastrarIngresso(ingresso),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IngressoCompletoDto>> obterIngressos()
    {
        return new ResponseEntity<>(servico.obterIngressos(),HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<IngressoDto> obterIngressoPorId(@PathVariable String id)
    {
        Optional<IngressoDto> retorno = servico.obterIngressoPorId(id);
        
        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirIngresso(@PathVariable String id)
    {
        servico.excluirIngresso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngressoDto> atualizarIngresso(@PathVariable String id, @Valid IngressoDto ingresso){
        Optional<IngressoDto> retorno = servico.atualizarIngressoPorId(id, ingresso);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

