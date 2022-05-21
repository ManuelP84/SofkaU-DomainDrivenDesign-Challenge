package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.Cart;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.Offer;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.ItemCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Discount;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class NotifyOfferProcessUseCase extends UseCase<TriggeredEvent<ItemCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ItemCreated> itemCreatedTriggeredEvent) {
        var event = itemCreatedTriggeredEvent.getDomainEvent();
        var cart = Cart.from(CartId.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        cart.createOffer(
                OfferId.of("12345"),
                ProductId.of("354303"),
                new Discount(15.0)
        );
        emit().onResponse(new ResponseEvents(cart.getUncommittedChanges()));
    }
}