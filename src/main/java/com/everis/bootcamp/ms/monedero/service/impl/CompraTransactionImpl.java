package com.everis.bootcamp.ms.monedero.service.impl;

import com.everis.bootcamp.ms.monedero.domain.dto.MonederoTransactionDto;
import com.everis.bootcamp.ms.monedero.domain.entity.CompraTransaction;
import com.everis.bootcamp.ms.monedero.domain.repository.CompraTransactionRepository;
import com.everis.bootcamp.ms.monedero.service.srv.CompraTransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompraTransactionImpl implements CompraTransactionService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CompraTransactionRepository repository;

    @Override
    public Flux<MonederoTransactionDto> findAll() {
        return repository.findAll().flatMap(this::getMonederoTransactionDto);
    }

    @Override
    public Mono<MonederoTransactionDto> findById(String id) {
        return repository.findById(id).flatMap(this::getMonederoTransactionDto);
    }

    @Override
    public Mono<MonederoTransactionDto> create(CompraTransaction compraTransaction) {
        return repository.save(compraTransaction).flatMap(this::getMonederoTransactionDto);
    }

    private Mono<MonederoTransactionDto> getMonederoTransactionDto(CompraTransaction compraTransaction) {
        return Mono.just(objectMapper.convertValue(compraTransaction, MonederoTransactionDto.class));
    }

    @Override
    public MonederoTransactionDto getMonederoDto(CompraTransaction compraTransaction) {
        return objectMapper.convertValue(compraTransaction, MonederoTransactionDto.class);
    }

    @Override
    public CompraTransaction getMonedero(MonederoTransactionDto monederoTransactionDto) {
        return objectMapper.convertValue(monederoTransactionDto, CompraTransaction.class);
    }

    /*@Override
    public Mono<CompraTransaction> findoriginNumber(String originNumber) {
        return repository.findoriginNumber(originNumber);
    }*/

}
