package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Description;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.PqrId;

public class PqrDescriptionUpdated extends DomainEvent {
    private final PqrId entityId;
    private final Description description;

    public PqrDescriptionUpdated(PqrId entityId, Description description) {
        super("sofkaU.user.pqrDescriptionUpdated");
        this.entityId = entityId;
        this.description = description;
    }

    public PqrId getEntityId() {
        return entityId;
    }

    public Description getDescription() {
        return description;
    }
}
