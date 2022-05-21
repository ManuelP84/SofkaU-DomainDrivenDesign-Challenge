package com.sofkau.domainDrivenDesignChallenge.domain.cart.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class CreateCart extends Command {
    private final Name name;
    private final CartId cartId;

    public CreateCart(CartId cartId, Name name) {
        this.name = name;
        this.cartId = cartId;
    }

    //Getter methods

    public CartId getCartId() {
        return cartId;
    }

    public Name getName() {
        return name;
    }
}
