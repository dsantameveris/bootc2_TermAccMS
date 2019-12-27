package com.everis.TermAccMS.Service;

import com.everis.TermAccMS.Model.TermAccount;
import com.everis.TermAccMS.Model.DTO.TermAccountDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TermAccountService
{
    
    //Get all TermAccounts
    public Flux<TermAccount> findAllAccounts();

    //Get all TermAccounts (DTO)
    public Flux<TermAccountDTO> findAllAccountsDTO();

    //Get account by Number
    public Mono<TermAccount> findAccountByNumber(String number);

    //Get account by Number (DTO)
    public Mono<TermAccountDTO> findAccountByNumberDTO(String number);

    //Get account by Owner Dni
    public Mono<TermAccount> findAccountByOwnerDni(String dni);

    //Get account by Owner Dni (DTO)
    public Mono<TermAccountDTO> findAccountByOwnerDniDTO(String dni);

    //Create TermAccount
    public Mono<TermAccount> addAccount(TermAccount account);

    //Delete Account
    public Mono<Void> delAccount(String number);

}