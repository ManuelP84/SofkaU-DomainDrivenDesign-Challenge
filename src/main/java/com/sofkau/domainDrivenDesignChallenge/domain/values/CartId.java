package com.sofkau.domainDrivenDesignChallenge.domain.values;

import co.com.sofka.domain.generic.Identity;

public class CartId extends Identity {

    public CartId(){
    }

    private CartId(String id){
        super(id);
    }

    public static CartId of(String id){
        return new CartId(id);
    }
}
