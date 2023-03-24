package com.example.filmes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.filmes.model.Filme;

public interface FilmeRepository extends MongoRepository<Filme, String>{
    
}
