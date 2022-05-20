package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class CartCreated extends DomainEvent {
    private final Name name;

    public CartCreated(Name name) {
        super("sofkaU.cart.cartCreated");
        this.name = name;
    }

    //Getter methods
    public Name getName() {
        return name;
    }
}
