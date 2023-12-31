package com.example.address.web;

import com.example.address.domain.dto.AddressRequestDto;
import com.example.address.domain.dto.AddressResponseDto;
import com.example.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/v1/address", produces = "application/json")
@RequiredArgsConstructor
public class AddressController {

    public final AddressService addressService;

    @GetMapping()
    public Flux<AddressResponseDto> findAll(){
        return this.addressService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<AddressResponseDto> finById(@PathVariable Integer id){
        return this.addressService.findById(id);
    }

    @GetMapping(value = "/adolescente/{id}")
    public Flux<AddressResponseDto> finByIdAdolescent(@PathVariable Integer id){
        return this.addressService.findByIdAolescent(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Mono<AddressResponseDto> create(@RequestBody AddressRequestDto dto){
        dto.setActive("A");
        return this.addressService.create(dto);
    }

    @PutMapping(value = "/{id}")
    public Mono<AddressResponseDto> update(@RequestBody AddressRequestDto dto, @PathVariable Integer id){
        return this.addressService.update(dto,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id){
        return this.addressService.delete(id);
    }
}
