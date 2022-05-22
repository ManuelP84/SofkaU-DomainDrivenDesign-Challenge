package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.CreateUser;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.UserCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateUserUseCaseTest {

    private final String ROOTID = "1234567abcde";

    private CreateUserUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateUserUseCase();
    }

    @Test
    void createUserHappyPass() {

        //arrange
        var command = new CreateUser(
                UserId.of(ROOTID),
                new Name("Manuel Pineda")
        );

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //asserts
        var event = (UserCreated)events.get(0);
        Assertions.assertEquals(command.getUserId().value(), event.aggregateRootId());
        Assertions.assertEquals(command.getName().value(), event.getName().value());
    }
}
