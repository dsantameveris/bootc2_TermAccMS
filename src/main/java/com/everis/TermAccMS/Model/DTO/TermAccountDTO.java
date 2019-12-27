package com.everis.TermAccMS.Model.DTO;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TermAccountDTO
{
    @NotBlank
    private String number;

    @NotBlank
    private String currency;

    @NotBlank
    private double balance;

    public TermAccountDTO(String number, String currency, double balance)
    {
        this.number = number;
        this.currency = currency;
        this.balance = balance;
    }
}