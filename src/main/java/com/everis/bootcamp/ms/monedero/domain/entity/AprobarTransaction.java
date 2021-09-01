package com.everis.bootcamp.ms.monedero.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document("CompraTransaction")
public class AprobarTransaction {
    @Id
    private String id;
    @NotNull
    private int Number;
    private LocalDateTime createAt;
}
