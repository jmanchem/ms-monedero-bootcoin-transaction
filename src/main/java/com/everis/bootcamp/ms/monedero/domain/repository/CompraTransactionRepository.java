package com.everis.bootcamp.ms.monedero.domain.repository;

import com.everis.bootcamp.ms.monedero.domain.entity.CompraTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CompraTransactionRepository extends ReactiveMongoRepository<CompraTransaction, String> {
    //Mono<CompraTransaction>  findoriginNumber (String originNumber);
}
