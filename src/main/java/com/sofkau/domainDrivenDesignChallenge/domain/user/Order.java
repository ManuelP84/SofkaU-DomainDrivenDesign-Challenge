package com.sofkau.domainDrivenDesignChallenge.domain.user;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class Order extends Entity<OrderId> {
    private Date   date;
    private CartId cartId;

    public Order(OrderId entityId, Date date, CartId cartId) {
        super(entityId);
        this.date = date;
        this.cartId = cartId;
    }

    //Behaviors
    public void updateDate(Date date) {
        this.date = date;
    }

    public void updateCartId(CartId cartId) {
        this.cartId = cartId;
    }

    // Attributes
    public Date date() {
        return date;
    }

    public CartId cartId() {
        return cartId;
    }
}
