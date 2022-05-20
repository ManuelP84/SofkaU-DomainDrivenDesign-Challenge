package com.sofkau.domainDrivenDesignChallenge.domain.cart.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class UpdateItemProductId extends Command {
    private final ItemId    itemId;
    private final ProductId productId;

    public UpdateItemProductId(ItemId entityId, ProductId productId) {
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
