package com.everis.TermAccMS.Repository;

import com.everis.TermAccMS.Model.TermAccount;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface TermAccountRepo extends ReactiveMongoRepository<TermAccount, String>
{
    Mono<TermAccount> findByNumber(String number);

    Mono<TermAccount> findByOwner_Dni(String dni);
}