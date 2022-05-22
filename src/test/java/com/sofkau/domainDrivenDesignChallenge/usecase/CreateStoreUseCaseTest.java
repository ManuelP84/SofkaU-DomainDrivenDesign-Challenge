package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.domainDrivenDesignChallenge.domain.store.commands.CreateStore;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.StoreCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateStoreUseCaseTest {

    private final String ROOTID = "1234567abcde";

    private CreateStoreUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateStoreUseCase();
    }

    @Test
    void createStoreHappyPass() {

        //arrange
        var command = new CreateStore(
                StoreId.of(ROOTID),
                new Name("Walmart")
        );

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //asserts
        var event = (StoreCreated)events.get(0);
        Assertions.assertEquals(command.getStoreId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getName().value(), event.getName().value());
    }
}
