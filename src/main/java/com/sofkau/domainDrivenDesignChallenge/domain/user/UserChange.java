package com.sofkau.domainDrivenDesignChallenge.domain.user;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.PqrCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.UserCreated;

public class UserChange extends EventChange {
    public UserChange(User user) {

        apply((UserCreated event) -> {
            user.name = event.getName();
        });

        apply((PqrCreated event) ->{
            
        });
    }
}
