package com.sofkau.domainDrivenDesignChallenge.domain.cart.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class CreateItem extends Command {
    private final ItemId    itemId;
    private final ProductId productId;
    private final Quantity  quantity;

    public CreateItem(ItemId entityId, ProductId productId, Quantity quantity) {
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
