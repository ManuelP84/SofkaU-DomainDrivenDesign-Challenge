package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.Offer;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.commands.CreateItem;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.commands.CreateOffer;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.CartCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.ItemCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.OfferCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Discount;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CreateOfferUseCaseTest {

    @InjectMocks
    private CreateOfferUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createOfferHappyPass() {

        //Arrange
        CartId cartId = CartId.of("xxxxx");
        OfferId offerId = OfferId.of("1234");
        ProductId productId = ProductId.of("5678");
        Discount discount = new Discount(20.0);
        var command = new CreateOffer(cartId, offerId, productId, discount);

        when(repository.getEventsBy("xxxxx")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //Asserts
        var event = (OfferCreated) events.get(0);
        Assertions.assertEquals(command.getProductId().value(), event.getProductId().value());
        Assertions.assertEquals(command.getDiscount().value(), event.getDiscount().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    private List<DomainEvent> history() {
        Name cartName = new Name("Sports");
        var event = new CartCreated(cartName);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
