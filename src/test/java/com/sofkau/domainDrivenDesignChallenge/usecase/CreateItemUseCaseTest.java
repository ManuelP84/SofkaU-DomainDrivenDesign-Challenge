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
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.CreateOrder;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.OrderCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.UserCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;
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

    @InjectMocks
    private CreateItemUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createItemHappyPass() {

        //Arrange
        CartId cartId = CartId.of("xxxxx");
        ItemId itemId = ItemId.of("1234");
        ProductId productId = ProductId.of("5678");
        Quantity quantity = new Quantity(5);
        var command = new CreateItem(cartId, itemId, productId, quantity);

        when(repository.getEventsBy("xxxxx")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //Asserts
        var event = (ItemCreated) events.get(0);
        Assertions.assertEquals(command.getProductId().value(), event.getProductId().value());
        Assertions.assertEquals(command.getQuantity().value(), event.getQuantity().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    private List<DomainEvent> history() {
        Name cartName = new Name("Sports");
        var event = new CartCreated(cartName);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
