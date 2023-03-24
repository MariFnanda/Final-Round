package com.example.ingressos.service;

import java.util.List;
import java.util.Optional;

import com.example.ingressos.shared.IngressoCompletoDto;
import com.example.ingressos.shared.IngressoDto;

public interface IngressoService {
    
    List<IngressoCompletoDto> obterIngressos();
    Optional<IngressoDto> obterIngressoPorId(String id);
    void excluirIngresso(String id);
    IngressoCompletoDto cadastrarIngresso(IngressoCompletoDto ingresso);
    Optional<IngressoDto> atualizarIngressoPorId(String id, IngressoDto dto);

    
}
