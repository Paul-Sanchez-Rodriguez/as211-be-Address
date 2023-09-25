package com.example.MsAdolescente;

import com.example.MsAdolescente.domain.dto.AdolescentRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescentResponseDto;
import com.example.MsAdolescente.service.AdolescentService;
import com.example.MsAdolescente.web.AdolescentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringWebfluxApiApplicationTests {

    @InjectMocks
    private AdolescentController adolescentController;

    @Mock
    private AdolescentService adolescentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Mock data
        AdolescentResponseDto dto1 = new AdolescentResponseDto();
        AdolescentResponseDto dto2 = new AdolescentResponseDto();
        when(adolescentService.findAll()).thenReturn(Flux.just(dto1, dto2));

        // Perform the test
        Flux<AdolescentResponseDto> result = adolescentController.findAll();
    }

    @Test
    public void testFindInactive() {
        // Mock data
        AdolescentResponseDto dto1 = new AdolescentResponseDto();
        AdolescentResponseDto dto2 = new AdolescentResponseDto();
        when(adolescentService.findInactive()).thenReturn(Flux.just(dto1, dto2));

        // Perform the test
        Flux<AdolescentResponseDto> result = adolescentController.findInactive();
    }

    @Test
    public void testFindById() {
        // Mock data
        AdolescentResponseDto dto = new AdolescentResponseDto();
        when(adolescentService.findById(15)).thenReturn(Mono.just(dto));

        // Perform the test
        Mono<AdolescentResponseDto> result = adolescentController.findById(15);
    }

    @Test
    public void testCreate() {
        // Mock data
        AdolescentRequestDto requestDto = new AdolescentRequestDto();
        AdolescentResponseDto responseDto = new AdolescentResponseDto();
        when(adolescentService.create(requestDto)).thenReturn(Mono.just(responseDto));

        // Perform the test
        Mono<AdolescentResponseDto> result = adolescentController.create(requestDto);
    }

    @Test
    public void testUpdate() {
        // Mock data
        AdolescentRequestDto requestDto = new AdolescentRequestDto();
        AdolescentResponseDto responseDto = new AdolescentResponseDto();
        when(adolescentService.update(1, requestDto)).thenReturn(Mono.just(responseDto));

        // Perform the test
        Mono<AdolescentResponseDto> result = adolescentController.update(1, requestDto);
    }

    @Test
    public void testDelete() {
        // Mock data
        when(adolescentService.delete(1)).thenReturn(Mono.empty());

        // Perform the test
        Mono<Void> result = adolescentController.delete(1);
    }

}
