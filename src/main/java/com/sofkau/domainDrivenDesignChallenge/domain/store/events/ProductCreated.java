package com.sofkau.domainDrivenDesignChallenge.domain.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.Price;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class ProductCreated extends DomainEvent {
    private final ProductId productId;
    private final Name name;
    private final Price price;

    public ProductCreated(ProductId entityId, Name name, Price price) {
        super("sofkaU.store.productCreated");
        this.productId = entityId;
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
