package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.commands.CreateCart;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.CartCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateCartUseCaseTest {

    private CreateCartUseCase useCase;

    private final String ROOTID = "1234abcd";

    @BeforeEach
    public void setup() {
        useCase = new CreateCartUseCase();
    }

    @Test
    void createCartHappyPass() {

        //arrange
        var command = new CreateCart(
                CartId.of("12345"),
                new Name("Accesorios")
        );

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //asserts
        var event = (CartCreated) events.get(0);
        Assertions.assertEquals(command.getCartId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getName().value(), event.getName().value());
    }
}
