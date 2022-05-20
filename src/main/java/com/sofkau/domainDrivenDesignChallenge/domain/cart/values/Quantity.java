package com.sofkau.domainDrivenDesignChallenge.domain.cart.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Quantity implements ValueObject<Integer> {
    private final Integer value;

    public Quantity(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value <= 0) {
            throw new IllegalArgumentException("The quantity must be greater than cero!");
        }
    }

    public Integer value() {
        return value;
    }
}
