package com.sofkau.domainDrivenDesignChallenge.domain.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.Price;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class ProductPriceUpdated extends DomainEvent {
    private final ProductId productId;
    private final Price price;

    public ProductPriceUpdated(ProductId productId, Price price) {
        super("sofkaU.store.productPriceUpdated");
        this.productId = productId;
        this.price = price;
    }

    // Getter methods
    public ProductId getProductId() {
        return productId;
    }

    public Price getPrice() {
        return price;
    }
}
