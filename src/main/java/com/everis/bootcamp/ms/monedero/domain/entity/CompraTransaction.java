package com.everis.bootcamp.ms.monedero.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document("CompraTransaction")
public class CompraTransaction {

    @Id
    private String id;

    @NotNull
    private int originNumber;

    @NotNull
    private int destinationNumber;

    @NotNull
    private Double bootcoin;

    @NotNull
    private String modoPago;

    private Status status;

    private LocalDateTime createAt;

    public enum Status {
        PENDING,
        REJECTED,
        SUCCESSFUL
    }

}
