package com.example.MsAdolescente.web;

import com.example.MsAdolescente.domain.dto.AdolescentRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescentResponseDto;
import com.example.MsAdolescente.service.AdolescentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping( value ="/adolescente", produces = "application/json")
@RequiredArgsConstructor
public class AdolescentController {

    private final AdolescentService adolescentService;


    @GetMapping(value = "list")
    public Flux<AdolescentResponseDto> findAll() {
        return this.adolescentService.findAll();
    }

    @GetMapping(value="listI")
    public Flux<AdolescentResponseDto> findInactive() {
        return this.adolescentService.findInactive();
    }

    @GetMapping(value = "/find/{id}")
    public Mono<AdolescentResponseDto> findById(@PathVariable Integer id) {
        return this.adolescentService.findById(id);
    }

    @PutMapping(value = "/updadte/{id}")
    public Mono<AdolescentResponseDto> update(@PathVariable Integer id, @RequestBody AdolescentRequestDto dto) {
        return this.adolescentService.update(id, dto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AdolescentResponseDto> create(@RequestBody AdolescentRequestDto dto) {
        return this.adolescentService.create(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return this.adolescentService.delete(id);
    }

    //New Controller
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/restore/{id}")
    public Mono<Void> restore(@PathVariable Integer id) {
        return this.adolescentService.restaurar(id);
    }

}
