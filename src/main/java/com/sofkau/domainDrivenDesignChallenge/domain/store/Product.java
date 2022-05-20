package com.sofkau.domainDrivenDesignChallenge.domain.store;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.Price;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class Product extends Entity<ProductId> {
    private Name  name;
    private Price price;

    public Product(ProductId entityId, Name name, Price price) {
        super(entityId);
        this.name = name;
        this.price = price;
    }

    // Behaviors
    public void updateName(Name name) {
        this.name = name;
    }

    public void updatePrice(Price price) {
        this.price = price;
    }

    //Attributes
    public Name name() {
        return name;
    }

    public Price price() {
        return price;
    }
}
