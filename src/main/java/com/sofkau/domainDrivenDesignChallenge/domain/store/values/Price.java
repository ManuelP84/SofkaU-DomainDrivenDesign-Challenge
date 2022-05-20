package com.sofkau.domainDrivenDesignChallenge.domain.store.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Price implements ValueObject<Double> {

    private final Double value;

    public Price(Double value){
        this.value = Objects.requireNonNull(value);
        if (this.value <= 0){
            throw new IllegalArgumentException("The price must be greater than cero!");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
