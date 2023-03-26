package com.example.ingressos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ingressos.model.Ingresso;


public interface IngressoRepository extends MongoRepository<Ingresso, String>{
    
}
