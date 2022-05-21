package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Description;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.PqrId;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;

public class CreatePqr extends Command {
    private UserId userId;
    private final PqrId       pqrId;
    private final Description description;

    public CreatePqr(UserId userId, PqrId entityId, Description description) {
        this.userId = userId;
        this.pqrId = entityId;
        this.description = description;
    }

    // Getter methods

    public UserId getUserId() {
        return userId;
    }

    public PqrId getPqrId() {
        return pqrId;
    }

    public Description getDescription() {
        return description;
    }
}
