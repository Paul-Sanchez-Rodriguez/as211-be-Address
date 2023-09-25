package com.example.address.web.feign;

import com.example.address.domain.model.Adolescent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "adolescent-service")
public interface AdolescentClientFeign {

    @GetMapping(value = "/adolescente/find/{id}")
    Adolescent findById(@PathVariable Integer id);
}
