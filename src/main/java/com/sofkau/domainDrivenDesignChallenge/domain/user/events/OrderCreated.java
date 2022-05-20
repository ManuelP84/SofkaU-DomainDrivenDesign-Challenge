package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class OrderCreated extends DomainEvent {
    private final OrderId orderId;
    private final Date    date;
    private final CartId cartId;

    public OrderCreated(OrderId entityId, Date date, CartId cartId) {
        super("sofkaU.user.orderCreated");
        this.orderId = entityId;
        this.date = date;
        this.cartId = cartId;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public CartId getCartId() {
        return cartId;
    }
}
