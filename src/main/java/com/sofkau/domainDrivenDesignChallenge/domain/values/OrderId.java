package com.sofkau.domainDrivenDesignChallenge.domain.values;

import co.com.sofka.domain.generic.Identity;

public class OrderId extends Identity {

    public OrderId() {
    }

    private OrderId(String id) {
        super(id);
    }

    public static OrderId of(String id) {
        return new OrderId(id);
    }
}
