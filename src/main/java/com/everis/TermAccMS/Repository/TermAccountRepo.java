package com.everis.TermAccMS.Repository;

import com.everis.TermAccMS.Model.TermAccount;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TermAccountRepo extends ReactiveMongoRepository<TermAccount, String>
{

}