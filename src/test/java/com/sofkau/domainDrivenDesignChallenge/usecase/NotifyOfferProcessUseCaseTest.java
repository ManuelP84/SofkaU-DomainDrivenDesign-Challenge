package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.CartCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.ItemCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.OfferCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotifyOfferProcessUseCaseTest {

    private final String ROOTID = "1234567abcde";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyOfferProcessTest(){

        //arrange
        var event1 = new CartCreated(
                new Name("Sports")
        );
        event1.setAggregateRootId(ROOTID);

        var event2 = new ItemCreated(
                ItemId.of("1234"),
                ProductId.of("xcxcx"),
                new Quantity(5)
        );
        event2.setAggregateRootId(ROOTID);

        var useCase = new NotifyOfferProcessUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(event1, event2));
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event2))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //asserts
        var offerEvent = (OfferCreated) events.get(0);
        Assertions.assertEquals("12345", offerEvent.getOfferId().value());
        Assertions.assertEquals("354303", offerEvent.getProductId().value());
        Assertions.assertEquals(15.0, offerEvent.getDiscount().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
