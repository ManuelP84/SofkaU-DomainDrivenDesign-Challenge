package com.sofkau.domainDrivenDesignChallenge.domain.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class ProductNameUpdated extends DomainEvent {
    private final ProductId productId;
    private final Name name;

    public ProductNameUpdated(ProductId entityId, Name name) {
        super("sofkaU.store.productNameUpdated");
        this.productId = entityId;
        this.name = name;
    }

    // Getter methods
    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }
}
