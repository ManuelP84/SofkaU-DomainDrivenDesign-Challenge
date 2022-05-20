package com.sofkau.domainDrivenDesignChallenge.domain.cart.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class CreateCart extends Command {
    private final Name name;

    public CreateCart(Name name) {
        this.name = name;
    }

    //Getter methods

    public Name getName() {
        return name;
    }
}
