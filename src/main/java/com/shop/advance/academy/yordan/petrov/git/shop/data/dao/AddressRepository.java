package com.shop.advance.academy.yordan.petrov.git.shop.data.dao;

import com.shop.advance.academy.yordan.petrov.git.shop.data.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findById(Long id);

    Optional<Address> findByCityName(String cityName);

    Optional<Address> findByStreetName(String streetName);

    Optional<Address> findByStreetNumber(String number);

    Optional<Address> findByStreetNumberAndStreetName(String number, String streetName);

}
