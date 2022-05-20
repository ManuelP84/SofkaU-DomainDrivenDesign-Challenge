package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class OrderCartIdUpdated extends DomainEvent {
    private final OrderId orderId;
    private final CartId  cartId;

    public OrderCartIdUpdated(OrderId entityId, CartId cartId) {
        super("sofkaU.user.orderCardIdUpdated");
        this.orderId = entityId;
        this.cartId = cartId;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public CartId getCartId() {
        return cartId;
    }
}
