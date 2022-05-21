package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class CreateOrder extends Command {
    private final UserId userId;
    private final OrderId orderId;
    private final Date date;
    private final CartId  cartId;

    public CreateOrder(UserId userId, OrderId entityId, Date date, CartId cartId) {
        this.userId = userId;
        this.orderId = entityId;
        this.cartId = cartId;
        this.date = date;
    }

    // Getter methods
    public UserId getUserId() {
        return userId;
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
