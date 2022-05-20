package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class UpdateOrderCartId extends Command {
    private final OrderId orderId;
    private final CartId  cartId;

    public UpdateOrderCartId(OrderId orderId, CartId cartId) {
        this.orderId = orderId;
        this.cartId = cartId;
    }

    //Getter methods
    public OrderId getOrderId() {
        return orderId;
    }

    public CartId getCartId() {
        return cartId;
    }
}
