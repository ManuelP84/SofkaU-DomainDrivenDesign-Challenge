package com.sofkau.domainDrivenDesignChallenge.domain.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class StoreCreated extends DomainEvent {
    private final Name name;

    public StoreCreated(Name name) {
        super("sofkaU.store.storeCreated");
        this.name = name;
    }

    // Getter methods
    public Name getName() {
        return name;
    }
}
