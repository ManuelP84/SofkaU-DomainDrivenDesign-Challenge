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


    @BeforeEach
    public void setup(){
        useCase = new CreateCartUseCase();
    }

    @Test
    void createCartHappyPass() {

        //Arrange
        CartId cartId = CartId.of("12345");
        Name cartName = new Name("Accesorios");
        var command = new CreateCart(cartId, cartName);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //Asserts
        var event = (CartCreated) events.get(0);
        Assertions.assertEquals(cartId.value(), event.aggregateRootId());
        Assertions.assertEquals(cartName.value(), event.getName().value());
    }
}
