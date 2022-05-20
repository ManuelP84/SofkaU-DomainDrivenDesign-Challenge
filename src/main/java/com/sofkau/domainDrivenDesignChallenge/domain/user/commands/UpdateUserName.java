package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class UpdateUserName extends Command {
    private final Name name;

    public UpdateUserName(Name name){
        this.name = name;
    }

    // Getter methods
    public Name getName() {
        return name;
    }
}
