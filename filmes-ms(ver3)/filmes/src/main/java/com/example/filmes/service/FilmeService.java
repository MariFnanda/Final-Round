package com.example.filmes.service;

import java.util.List;
import java.util.Optional;

import com.example.filmes.shared.FilmeDto;
import com.example.filmes.shared.FilmesDto;

public interface FilmeService {
    
    List<FilmesDto> obterTodos();
    Optional<FilmeDto> obterPorId(String id);
    void excluirPorId(String id);
    FilmesDto cadastrar(FilmesDto dto);
    Optional<FilmesDto> atualizarPorId(String id, FilmesDto dto);
}
