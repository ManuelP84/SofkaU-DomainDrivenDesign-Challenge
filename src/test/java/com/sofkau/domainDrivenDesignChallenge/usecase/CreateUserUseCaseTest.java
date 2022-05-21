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

    private CreateUserUseCase useCase;


    @BeforeEach
    public void setup(){
        useCase = new CreateUserUseCase();
    }

    @Test
    void createUserHappyPass() {

        //Arrange
        UserId userId = UserId.of("12345");
        Name userName = new Name("Manuel Pineda");
        var command = new CreateUser(userId, userName);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //Asserts
        var event = (UserCreated)events.get(0);
        Assertions.assertEquals(userId.value(), event.aggregateRootId());
        Assertions.assertEquals(userName.value(), event.getName().value());
    }
}
