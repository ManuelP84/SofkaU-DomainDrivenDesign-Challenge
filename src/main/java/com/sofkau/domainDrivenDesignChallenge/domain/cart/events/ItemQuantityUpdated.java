package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;

public class ItemQuantityUpdated extends DomainEvent {
    private final ItemId itemId;
    private final Quantity quantity;

    public ItemQuantityUpdated(ItemId entityId, Quantity quantity) {
        super("sofkaU.cart.itemQuantityUpdated");
        this.itemId = entityId;
        this.quantity = quantity;
    }

    //Getter methods
    public ItemId getItemId() {
        return itemId;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
