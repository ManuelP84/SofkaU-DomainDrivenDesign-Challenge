package com.sofkau.domainDrivenDesignChallenge.domain.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;

public class CreateStore extends Command {
    private final StoreId storeId;
    private final Name    name;

    public CreateStore(StoreId storeId, Name name) {
        this.storeId = storeId;
        this.name = name;
    }

    // Getter methods
    public StoreId getStoreId() {
        return storeId;
    }

    public Name getName() {
        return name;
    }
}
