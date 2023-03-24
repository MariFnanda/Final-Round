package com.example.ingressos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ingressos.shared.IngressoCompletoDto;
import com.example.ingressos.shared.IngressoDto;
import com.example.ingressos.model.Ingresso;
import com.example.ingressos.httpClient.CinemaClient;
import com.example.ingressos.repository.IngressoRepository;

@Service
public class IngressoServiceImp implements IngressoService{
    
    @Autowired
    private IngressoRepository repository;
    
    @Autowired
    private CinemaClient filmeClient;
    
    @Override
    public List<IngressoCompletoDto> obterIngressos() {
        List<Ingresso> ingressos = repository.findAll();
        List<IngressoCompletoDto> dto = ingressos.stream().map(p -> new ModelMapper().map(p, IngressoCompletoDto.class)).collect(Collectors.toList());
        return dto;
    }
    
    @Override
    public Optional<IngressoDto> obterIngressoPorId(String id) {
            
        Optional<Ingresso> ingresso = repository.findById(id);
        if(ingresso.isPresent()){
            IngressoDto ingressoComFilme = new ModelMapper().map(ingresso, IngressoDto.class);
            ingressoComFilme.setDadosFilme(filmeClient.obterFilme(ingressoComFilme.getIdFilme()));
            return Optional.of(ingressoComFilme);
        }else{
            return Optional.empty();
        }
    }
    
    @Override
    public void excluirIngresso(String id) {
        repository.deleteById(id);
    }
    
    @Override
    public IngressoCompletoDto cadastrarIngresso(IngressoCompletoDto dto) {
        Ingresso ingresso = new ModelMapper().map(dto, Ingresso.class);
    
        repository.save(ingresso);
        return new ModelMapper().map(ingresso,IngressoCompletoDto.class);
    }
    
    @Override
    public Optional<IngressoDto> atualizarIngressoPorId(String id, IngressoDto dto) {
        Optional<Ingresso> retorno = repository.findById(id);
    
        if(retorno.isPresent()){
            Ingresso ingressoRetorno = new ModelMapper().map(dto, Ingresso.class);
            ingressoRetorno.setId(id);
            repository.save(ingressoRetorno);
            return Optional.of(new ModelMapper().map(ingressoRetorno, IngressoDto.class));
        }else{
            return Optional.empty();
        }
    }   
}
    
