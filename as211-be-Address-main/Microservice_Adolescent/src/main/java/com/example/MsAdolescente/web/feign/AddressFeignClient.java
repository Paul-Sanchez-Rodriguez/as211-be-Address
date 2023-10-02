package com.example.MsAdolescente.web.feign;

import com.example.MsAdolescente.domain.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

import java.util.List;

@FeignClient(value = "address-service")
public interface AddressFeignClient {

    @GetMapping(value = "/v1/address/adolescente/{id}")
    List<Address> findById(@PathVariable Integer id);
}
