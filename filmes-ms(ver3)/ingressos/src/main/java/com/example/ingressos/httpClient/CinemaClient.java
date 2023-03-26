package com.example.ingressos.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ingressos.model.Filme;

@FeignClient(name = "filme", fallback = CinemaClientFallBack.class)
public interface CinemaClient {

    @RequestMapping(value="/catalogo/{id}", method=RequestMethod.GET)
    Filme obterFilme(@PathVariable String id);
    
}
class CinemaClientFallBack implements CinemaClient{
    @Override
    public Filme obterFilme(String id){
        return new Filme();
    }
}
