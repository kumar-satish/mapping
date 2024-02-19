package com.sesc.mapping.repositories;

import com.sesc.mapping.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
