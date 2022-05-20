package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class ItemCreated extends DomainEvent {
    private final ItemId itemId;
    private final ProductId productId;
    private final Quantity quantity;

    public ItemCreated(ItemId entityId, ProductId productId, Quantity quantity) {
        super("sofkaU.cart.itemCreated");
        this.itemId = entityId;
        this.productId = productId;
        this.quantity = quantity;
    }

    //Getter methods
    public ItemId getItemId() {
        return itemId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
