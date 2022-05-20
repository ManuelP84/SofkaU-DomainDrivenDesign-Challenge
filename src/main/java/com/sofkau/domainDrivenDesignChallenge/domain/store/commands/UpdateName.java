package com.sofkau.domainDrivenDesignChallenge.domain.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class UpdateName extends Command {
    private final Name name;

    public UpdateName(Name name){
        this.name = name;
    }

    //Getter methods
    public Name getName() {
        return name;
    }
}
