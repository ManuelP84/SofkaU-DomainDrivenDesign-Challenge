package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.commands.CreateItem;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.CartCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.ItemCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;
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
public class CreateItemUseCaseTest {

    private final String ROOTID = "1234abcd";

    @InjectMocks
    private CreateItemUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createItemHappyPass() {

        //arrange
        var command = new CreateItem(
                CartId.of(ROOTID),
                ItemId.of("1234"),
                ProductId.of("5678"),
                new Quantity(5)
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
        var event = (ItemCreated) events.get(0);
        Assertions.assertEquals(command.getProductId().value(), event.getProductId().value());
        Assertions.assertEquals(command.getQuantity().value(), event.getQuantity().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

    private List<DomainEvent> history() {
        var event = new CartCreated(
                new Name("Sports")
        );
        event.setAggregateRootId(ROOTID);
        return List.of(event);
    }
}
