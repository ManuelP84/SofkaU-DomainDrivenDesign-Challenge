package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class CreateUser extends Command {
    private UserId userId;
    private Name   name;

    public CreateUser(UserId entityId, Name name) {
        this.userId = entityId;
        this.name = name;
    }

    // Getter methods
    public UserId getUserId() {
        return userId;
    }

    public Name getName() {
        return name;
    }
}
