package com.sofkau.domainDrivenDesignChallenge.domain.user;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Description;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.PqrId;

import java.util.Objects;

public class Pqr extends Entity<PqrId> {

    private Description description;

    public Pqr(PqrId entityId, Description description) {
        super(entityId);
        this.description = description;
    }

    //Behaviors
    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    // Attributes
    public Description description() {
        return description;
    }
}
