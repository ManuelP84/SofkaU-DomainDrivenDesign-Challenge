package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.CreateOrder;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.OrderCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.UserCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateOrderUseCaseTest {

    private final String ROOTID = "1234abcd";

    @InjectMocks
    private CreateOrderUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createOrderHappyPass() {

        //arrange
        var command = new CreateOrder(
                UserId.of(ROOTID),
                OrderId.of("1234"),
                new Date("20/05/2022"),
                CartId.of("5678")
        );

        when(repository.getEventsBy(ROOTID)).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //asserts
        var event = (OrderCreated) events.get(0);
        Assertions.assertEquals(command.getDate().value(), event.getDate().value());
        Assertions.assertEquals(command.getCartId().value(), event.getCartId().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

    private List<DomainEvent> history() {
        var event = new UserCreated(
                new Name("Manuel")
        );
        event.setAggregateRootId(ROOTID);
        return List.of(event);
    }
}
