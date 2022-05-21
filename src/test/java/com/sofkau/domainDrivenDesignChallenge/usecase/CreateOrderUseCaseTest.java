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

    @InjectMocks
    private CreateOrderUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createOrderHappyPass() {

        //Arrange
        UserId userId = UserId.of("xxxxx");
        OrderId orderId = OrderId.of("1234");
        CartId cartId = CartId.of("5678");
        Date date = new Date("20/05/2022");
        var command = new CreateOrder(userId, orderId, date, cartId);

        when(repository.getEventsBy("xxxxx")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //Asserts
        var event = (OrderCreated) events.get(0);
        Assertions.assertEquals("20/05/2022", event.getDate().value());
        Assertions.assertEquals("5678", event.getCartId().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    private List<DomainEvent> history() {
        Name userName = new Name("Manuel Pineda");
        var event = new UserCreated(userName);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
