package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class CreateOrder extends Command {
    private final OrderId orderId;
    private final CartId  cartId;

    public CreateOrder(OrderId entityId, Date date, CartId cartId) {
        this.orderId = entityId;
        this.cartId = cartId;
    }

    // Getter methods
    public OrderId getEntityId() {
        return orderId;
    }

    public CartId getCartId() {
        return cartId;
    }
}
