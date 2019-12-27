package com.everis.TermAccMS.Controller;

import com.everis.TermAccMS.Model.TermAccount;
import com.everis.TermAccMS.Model.DTO.TermAccountDTO;
import com.everis.TermAccMS.Service.Impl.TermAccountServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/termacc")
public class TermAccountController
{
    //Service Instance
    @Autowired
    private TermAccountServiceImpl service;

    //Get all Term Accounts
    @GetMapping("/all")
    public Flux<TermAccount> getAllAccounts()
    {
        return service.findAllAccounts();
    }

    //Get all Term Accounts
    @GetMapping("/alldto")
    public Flux<TermAccountDTO> getAllAccountsDTO()
    {
        return service.findAllAccountsDTO();
    }

    //Get account by Number
    @GetMapping("/number/{number}")
    public Mono<TermAccount> getAccountByNumber(@PathVariable String number)
    {
        return service.findAccountByNumber(number);
    }

    //Get account by Number (DTO)
    @GetMapping("/numberdto/{number}")
    public Mono<TermAccountDTO> getAccountByNumberDTO(String number)
    {
        return service.findAccountByNumberDTO(number);
    }

    //Get account by Own Dni
    @GetMapping("/dni/{dni}")
    public Mono<TermAccount> getAccountByOwnerDni(@PathVariable String dni)
    {
        return service.findAccountByOwnerDni(dni);
    }

    //Get account by Own Dni (DTO)
    @GetMapping("/dnidto/{dni}")
    public Mono<TermAccountDTO> getAccountByOwnerDniDTO(@PathVariable String dni)
    {
        return service.findAccountByOwnerDniDTO(dni);
    }

    //Create Term Account
    @PostMapping
    public Mono<TermAccount> createAccount(@RequestBody TermAccount account)
    {
        return service.addAccount(account);
    }

    //Update Term Account Data
    @PutMapping("/edit/{number}")
    public Mono<TermAccount> editAccount(@RequestBody TermAccount account, @PathVariable String number)
    {
        return service.findAccountByNumber(number)
                        .flatMap(ac -> 
                        {
                            ac.setCurrency(account.getCurrency());
                            return service.addAccount(ac);
                        });
    }

    //Delete Account
    @DeleteMapping("/delete/{number}")
    public Mono<Void> deleteAccount(@PathVariable String number)
    {
        return service.delAccount(number);
    }


}