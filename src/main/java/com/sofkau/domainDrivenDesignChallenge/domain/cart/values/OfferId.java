package com.sofkau.domainDrivenDesignChallenge.domain.cart.values;

import co.com.sofka.domain.generic.Identity;

public class OfferId extends Identity {

    public OfferId(){
    }

    private OfferId(String id){
        super(id);
    }

    public static OfferId of(String id){
        return new OfferId(id);
    }
}
