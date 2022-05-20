package com.sofkau.domainDrivenDesignChallenge.domain.cart.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;

public class UpdateItemQuantity extends Command {
    private final ItemId   itemId;
    private final Quantity quantity;

    public UpdateItemQuantity(ItemId entityId, Quantity quantity) {
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
