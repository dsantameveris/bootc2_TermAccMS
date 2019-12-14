package com.everis.TermAccMS.Service;

import com.everis.TermAccMS.Model.TermAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TermAccountService
{
    //Create TermAccount
    public Mono<TermAccount> addAccount(TermAccount account);

    //Delete Account
    public Mono<Void> delAccount(TermAccount account);

    //Get all TermAccounts from DB
    public Flux<TermAccount> findAllAccounts();
}