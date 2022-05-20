package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Description;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.PqrId;

public class PqrDescriptionUpdated extends DomainEvent {
    private final PqrId       pqrId;
    private final Description description;

    public PqrDescriptionUpdated(PqrId entityId, Description description) {
        super("sofkaU.user.pqrDescriptionUpdated");
        this.pqrId = entityId;
        this.description = description;
    }

    public PqrId getPqrId() {
        return pqrId;
    }

    public Description getDescription() {
        return description;
    }
}
