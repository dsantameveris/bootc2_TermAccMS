package com.everis.TermAccMS.Service.Impl;

import com.everis.TermAccMS.Model.TermAccount;
import com.everis.TermAccMS.Repository.TermAccountRepo;
import com.everis.TermAccMS.Service.TermAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TermAccountServiceImpl implements TermAccountService
{

    @Autowired
    private TermAccountRepo repo;

    //Create Account
    @Override
    public Mono<TermAccount> addAccount(TermAccount account) {
        return repo.save(account);
    }

    //DeleteAccount
    @Override
    public Mono<Void> delAccount(TermAccount account) {
        return repo.delete(account);
    }

    //Get All Accounts
    @Override
    public Flux<TermAccount> findAllAccounts() {
        return repo.findAll();
    }    
}