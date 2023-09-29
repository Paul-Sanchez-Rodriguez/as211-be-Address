package com.example.MsAdolescente.repository;

import com.example.MsAdolescente.domain.model.Adolescent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AdolescentRepository extends ReactiveCrudRepository<Adolescent, Integer>{
}
