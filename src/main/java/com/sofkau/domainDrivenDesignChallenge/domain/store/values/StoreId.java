package com.sofkau.domainDrivenDesignChallenge.domain.store.values;

import co.com.sofka.domain.generic.Identity;

public class StoreId extends Identity {

    public StoreId() {
    }

    private StoreId(String id) {
        super(id);
    }

    public static StoreId of(String id) {
        return new StoreId(id);
    }
}
