package com.example.MsAdolescente.service;

import com.example.MsAdolescente.domain.dto.AdolescentRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescentResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AdolescentService {

    Mono<AdolescentResponseDto> findById(Integer id);

    Flux<AdolescentResponseDto> findAll();

    Flux<AdolescentResponseDto> findInactive();

    Mono<AdolescentResponseDto> create(AdolescentRequestDto request);

    Mono<AdolescentResponseDto> update(Integer id, AdolescentRequestDto request);

    Mono<Void> delete(Integer id);

    //New Interface
    Mono<Void> restaurar(Integer id);
}
