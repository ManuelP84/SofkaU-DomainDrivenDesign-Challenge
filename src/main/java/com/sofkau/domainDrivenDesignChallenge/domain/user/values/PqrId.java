package com.sofkau.domainDrivenDesignChallenge.domain.user.values;

import co.com.sofka.domain.generic.Identity;

public class PqrId extends Identity {

    public PqrId(){

    }

    private PqrId(String id){
        super(id);
    }

    public static PqrId of(String id){
        return new PqrId(id);
    }
}
