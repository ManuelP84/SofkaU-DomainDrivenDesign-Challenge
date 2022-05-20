package com.sofkau.domainDrivenDesignChallenge.domain.cart;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class Item extends Entity<ItemId> {
    private ProductId productId;
    private Quantity  quantity;

    public Item(ItemId entityId, ProductId productId, Quantity quantity) {
        super(entityId);
        this.productId = productId;
        this.quantity = quantity;
    }

    //Behaviors
    public void updateProductId(ProductId productId) {
        this.productId = productId;
    }

    public void updateQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    //Attributes
    public ProductId productId() {
        return productId;
    }

    public Quantity quantity() {
        return quantity;
    }
}
