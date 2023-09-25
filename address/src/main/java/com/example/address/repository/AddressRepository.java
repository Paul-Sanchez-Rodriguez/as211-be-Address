package com.example.address.repository;

import com.example.address.domain.model.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AddressRepository extends ReactiveCrudRepository<Address, Integer> {
}
