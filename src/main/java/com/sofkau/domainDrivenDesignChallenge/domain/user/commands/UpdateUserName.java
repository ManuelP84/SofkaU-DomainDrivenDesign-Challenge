package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class UpdateUserName extends Command {
    private final UserId userId;
    private final Name name;

    public UpdateUserName(UserId userId, Name name) {
        this.userId = userId;
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
