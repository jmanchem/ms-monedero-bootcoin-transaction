package com.everis.bootcamp.ms.monedero.service.srv;

import com.everis.bootcamp.ms.monedero.domain.dto.MonederoTransactionDto;
import com.everis.bootcamp.ms.monedero.domain.entity.CompraTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompraTransactionService {

    Flux<MonederoTransactionDto> findAll();

    Mono<MonederoTransactionDto> findById(String id);

    Mono<MonederoTransactionDto> create(CompraTransaction compraTransaction);

    MonederoTransactionDto getMonederoDto(CompraTransaction compraTransaction);

    CompraTransaction getMonedero(MonederoTransactionDto monederoTransactionDto);

    //Mono<CompraTransaction>  findoriginNumber (String originNumber);
}
