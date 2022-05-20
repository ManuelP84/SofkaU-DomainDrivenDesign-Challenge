package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class OrderCardIdUpdated extends DomainEvent {
    private final OrderId entityId;
    private final CartId cartId;

    public OrderCardIdUpdated(OrderId entityId, CartId cartId) {
        super("sofkaU.user.orderCardIdUpdated");
        this.entityId = entityId;
        this.cartId = cartId;
    }

    public OrderId getEntityId() {
        return entityId;
    }

    public CartId getCartId() {
        return cartId;
    }
}
