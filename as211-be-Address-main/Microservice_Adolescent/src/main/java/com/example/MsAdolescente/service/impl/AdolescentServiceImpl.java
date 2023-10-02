package com.example.MsAdolescente.service.impl;

import com.example.MsAdolescente.domain.dto.AdolescentRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescentResponseDto;
import com.example.MsAdolescente.domain.mapper.AdolescentMapper;
import com.example.MsAdolescente.domain.model.Address;
import com.example.MsAdolescente.exception.ResourceNotFoundException;
import com.example.MsAdolescente.repository.AdolescentRepository;
import com.example.MsAdolescente.service.AdolescentService;
import com.example.MsAdolescente.web.feign.AddressFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

import static com.example.MsAdolescente.domain.mapper.AdolescentMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdolescentServiceImpl implements AdolescentService {

    private final AdolescentRepository adolescentRepository;

    private final AddressFeignClient addressFeignClient;

    @Override
    public Mono<AdolescentResponseDto> findById(Integer id) {
        List<Address> address = addressFeignClient.findById(id);
        return this.adolescentRepository.findById(id)
                .map(adolescent -> {
                    AdolescentResponseDto dto = AdolescentMapper.toDto(adolescent);
                    dto.setAddress(address);
                    return dto;
                });
    }

    @Override
    public Flux<AdolescentResponseDto> findAll() {
        return this.adolescentRepository.findAll()
                .filter(adolescent -> "A".equals(adolescent.getActive()))
                .publishOn(Schedulers.boundedElastic())
                .map(adolescent -> {
                    List<Address> address = addressFeignClient.findById(adolescent.getId());
                    AdolescentResponseDto dto = AdolescentMapper.toDto(adolescent);
                    dto.setAddress(address);
                    return dto;
                });
    }

    @Override
    public Flux<AdolescentResponseDto> findInactive() {
        return this.adolescentRepository.findAll()
                .filter(adolescent -> adolescent.getActive().equals("I"))
                .publishOn(Schedulers.boundedElastic())
                .map(adolescent -> {
                    List<Address> address = addressFeignClient.findById(adolescent.getId());
                    AdolescentResponseDto dto = AdolescentMapper.toDto(adolescent);
                    dto.setAddress(address);
                    return dto;
                });
    }

    @Override
    public Mono<AdolescentResponseDto> create(AdolescentRequestDto request) {
        return this.adolescentRepository.save(toModel(request))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<AdolescentResponseDto> update(Integer id, AdolescentRequestDto request) {
        return this.adolescentRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .flatMap(adolescent -> this.adolescentRepository.save(toModel(adolescent.getId(), request)))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.adolescentRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .flatMap(adolescent -> {
                    adolescent.setActive("I");
                    return this.adolescentRepository.save(adolescent);
                })
                .doOnSuccess(unused -> log.info("Se elimino el adolescente con id: {}", id))
                .then();
    }
    //New Service
    @Override
    public Mono<Void> restaurar(Integer id) {
        return this.adolescentRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .flatMap(adolescent -> {
                    adolescent.setActive("A");
                    return this.adolescentRepository.save(adolescent);
                })
                .doOnSuccess(unused -> log.info("Se actualizó el estado a inactivo para el adolescente con id: {}", id))
                .then();
    }

}
