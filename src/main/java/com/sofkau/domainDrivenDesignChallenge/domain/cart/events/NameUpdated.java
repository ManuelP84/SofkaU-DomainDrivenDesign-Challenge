package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class NameUpdated extends DomainEvent {
    private final Name name;

    public NameUpdated(Name name) {
        super("sofkaU.cart.nameUpdated");
        this.name = name;
    }

    //Getter methods
    public Name getName() {
        return name;
    }
}
