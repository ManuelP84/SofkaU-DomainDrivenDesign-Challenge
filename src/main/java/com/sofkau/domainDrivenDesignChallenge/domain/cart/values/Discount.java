package com.sofkau.domainDrivenDesignChallenge.domain.cart.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Discount implements ValueObject<Double> {
    private final Double value;

    public Discount(Double value) {
        this.value = Objects.requireNonNull(value);
        if (this.value <= 0) {
            throw new IllegalArgumentException("The discount must be greater than cero!");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(value, discount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
