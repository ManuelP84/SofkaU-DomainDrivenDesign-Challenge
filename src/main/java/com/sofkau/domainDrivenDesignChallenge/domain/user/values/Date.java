package com.sofkau.domainDrivenDesignChallenge.domain.user.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Date implements ValueObject<String> {
    private final String value;

    public Date(String value){
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("The date can't be empty!");
        }

        if (this.value.length() < 5){
            throw new IllegalArgumentException("The date must contain at least 5 characters as follows xx-xx-xx ");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(value, date.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
