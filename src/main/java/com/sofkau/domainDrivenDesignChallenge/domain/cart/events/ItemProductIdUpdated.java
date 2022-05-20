package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class ItemProductIdUpdated extends DomainEvent {
    private final ItemId itemId;
    private final ProductId productId;

    public ItemProductIdUpdated(ItemId entityId, ProductId productId) {
        super("sofkaU.cart.itemProductIdUpdated");
        this.itemId = entityId;
        this.productId = productId;
    }

    //Getter methods
    public ItemId getItemId() {
        return itemId;
    }

    public ProductId getProductId() {
        return productId;
    }
}
