package com.shop.advance.academy.yordan.petrov.git.shop.data.dao;

import com.shop.advance.academy.yordan.petrov.git.shop.data.models.Card;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.Transaction;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findById(Long id);

    Optional<Transaction> findByNumber(String number);

    Optional<Transaction> findByRecipient(Card card);

    Optional<Transaction> findBySender(Card card);

    Optional<Transaction> findAllByRecipient(Card card);

    Optional<Transaction> findAllBySender(Card card);

    Optional<Transaction> findAllByDateCreated(Instant dateCreated);

    Optional<Transaction> findAllByDateCompleted(Instant dateComplected);

    Optional<Transaction> findAllByDateUpdated(Instant dateUpdated);

    Optional<Transaction> findAllByTransactionStatus(TransactionStatus status);

}
