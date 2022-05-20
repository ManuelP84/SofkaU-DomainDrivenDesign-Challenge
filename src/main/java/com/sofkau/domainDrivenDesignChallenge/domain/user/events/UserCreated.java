package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class UserCreated extends DomainEvent {
    private final Name name;

    public UserCreated(Name name) {
        super("sofkaU.user.UserCreated");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
