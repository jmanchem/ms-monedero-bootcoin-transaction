package com.everis.bootcamp.ms.monedero.router;

import com.everis.bootcamp.ms.monedero.handler.CompraTransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFuntionConfig {

    @Bean
    public RouterFunction<ServerResponse> routes (CompraTransactionHandler handler) {
        return route(GET("/CompraTransaction"), handler::findAll)
                .andRoute(GET("/CompraTransaction/{id}"), handler::findId)
                .andRoute(POST("/CompraTransaction"),handler::create)
                .andRoute(POST("/AprobarTransaction"),handler::aprobarTransact);
    }

}
