package com.everis.TermAccMS.Service.Impl;

import com.everis.TermAccMS.Model.TermAccount;
import com.everis.TermAccMS.Model.DTO.TermAccountDTO;
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

    //Get All Accounts
    @Override
    public Flux<TermAccount> findAllAccounts() {
        return repo.findAll();
    }

    //Get All Accounts (DTO)
    @Override
    public Flux<TermAccountDTO> findAllAccountsDTO() {
        return repo.findAll().map(account -> new TermAccountDTO(account.getNumber(), account.getCurrency(), account.getBalance()));
    }

    //Get account by Number
    public Mono<TermAccount> findAccountByNumber(String number)
    {
        return repo.findByNumber(number);
    }

    //Get account by Number (DTO)
    public Mono<TermAccountDTO> findAccountByNumberDTO(String number)
    {
        return repo.findByNumber(number).map(account -> new TermAccountDTO(account.getNumber(), account.getCurrency(), account.getBalance()));
    }

    //Get account by Owner Dni
    public Mono<TermAccount> findAccountByOwnerDni(String dni)
    {
        return repo.findByOwner_Dni(dni);
    }

    //Get account by Owner Dni (DTO)
    public Mono<TermAccountDTO> findAccountByOwnerDniDTO(String dni)
    {
        return repo.findByOwner_Dni(dni).map(account -> new TermAccountDTO(account.getNumber(), account.getCurrency(), account.getBalance()));
    }

    //Create Account
    @Override
    public Mono<TermAccount> addAccount(TermAccount account) {
        return repo.save(account);
    }

    //DeleteAccount
    @Override
    public Mono<Void> delAccount(String number) {
        return repo.findByNumber(number).flatMap(a -> repo.delete(a));
    }

  
}