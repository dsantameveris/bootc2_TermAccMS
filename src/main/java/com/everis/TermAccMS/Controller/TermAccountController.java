package com.everis.TermAccMS.Controller;

import com.everis.TermAccMS.Model.TermAccount;
import com.everis.TermAccMS.Service.Impl.TermAccountServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TermAccountController
{
    //Service Instance
    @Autowired
    private TermAccountServiceImpl service;

    //Create Term Account
    @PostMapping("/termacc/create")
    public Mono<TermAccount> createAccount(TermAccount account)
    {
        return service.addAccount(account);
    }

    //Delete Account
    @DeleteMapping("/termacc/delete")
    public Mono<Void> deleteAccount(TermAccount account)
    {
        return service.delAccount(account);
    }

    @GetMapping("/termacc/all")
    //Get all Term Accounts
    public Flux<TermAccount> getAllAccounts()
    {
        return service.findAllAccounts();
    }
}