package com.sofkau.domainDrivenDesignChallenge.domain.user.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;

public class UserId extends Identity {

    public UserId() {
    }

    private UserId(String id) {
        super(id);
    }

    public static UserId of(String id) {
        return new UserId(id);
    }
}
