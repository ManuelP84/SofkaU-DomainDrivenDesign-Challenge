package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class UserNameUpdated extends DomainEvent {
    private final Name name;

    public UserNameUpdated(Name name) {
        super("sofkaU.user.userNameUpdated");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
