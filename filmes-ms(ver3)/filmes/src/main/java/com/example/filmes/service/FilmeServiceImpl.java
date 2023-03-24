package com.example.filmes.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filmes.model.Filme;
import com.example.filmes.repository.FilmeRepository;
import com.example.filmes.shared.FilmeDto;
import com.example.filmes.shared.FilmesDto;

@Service
public class FilmeServiceImpl implements FilmeService{
    @Autowired
    private FilmeRepository repositorio;

    @Override
    public List<FilmesDto> obterTodos(){
        List<Filme> filmes = repositorio.findAll();

        return filmes.stream()
        .map(f -> new ModelMapper().map(f, FilmesDto.class))
        .collect(Collectors.toList());
        
    }

    @Override
    public Optional<FilmeDto> obterPorId(String id){
        Optional<Filme> filme = repositorio.findById(id);

        if (filme.isPresent()){    
            return Optional.of(new ModelMapper()
            .map(filme.get(), FilmeDto.class));       
        }
        return Optional.empty();
    }

    @Override
    public void excluirPorId(String id){
        repositorio.deleteById(id);
    }

    @Override
    public FilmesDto cadastrar(FilmesDto dto){
        Filme filme = new ModelMapper()
        .map(dto, Filme.class);
        repositorio.save(filme);
        return new ModelMapper()
        .map(filme, FilmesDto.class);
    }

    @Override
    public Optional<FilmesDto> atualizarPorId(String id, FilmesDto dto){
        Optional<Filme> retorno = repositorio.findById(id);

        if (retorno.isPresent()){
            Filme filme = new ModelMapper()
            .map(dto, Filme.class);
            filme.setId(id);
            repositorio.save(filme);
            return Optional.of(new ModelMapper()
            .map(filme, FilmesDto.class));
        } else{
            return Optional.empty();
        }
    }
    
}
