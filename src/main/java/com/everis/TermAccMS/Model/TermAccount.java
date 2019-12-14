package com.everis.TermAccMS.Model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "TermAccs")
public class TermAccount
{
    @Id
    private String Id;

    @NotBlank
    private String number;

    @NotBlank
    private String owners;

    @NotBlank
    private String currency;

    @NotBlank
    private int balance;

    @NotBlank
    private int time;
}