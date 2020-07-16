package com.shop.advance.academy.yordan.petrov.git.shop.data.dao;

import com.shop.advance.academy.yordan.petrov.git.shop.data.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findById(Long id);

}

