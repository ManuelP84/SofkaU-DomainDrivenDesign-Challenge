package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Description;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.PqrId;

public class CreatePqr extends Command {
    private final PqrId pqrId;
    private final Description description;

    public CreatePqr(PqrId entityId, Description description){

        this.pqrId = entityId;
        this.description = description;
    }

    // Getter methods
    public PqrId getPqrId() {
        return pqrId;
    }

    public Description getDescription() {
        return description;
    }
}
