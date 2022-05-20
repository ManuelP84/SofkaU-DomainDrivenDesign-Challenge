package com.sofkau.domainDrivenDesignChallenge.domain.cart;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Discount;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class Offer extends Entity<OfferId> {
    private ProductId productId;
    private Discount discount;

    public Offer(OfferId entityId, ProductId productId, Discount discount) {
        super(entityId);
        this.productId = productId;
        this.discount = discount;
    }

    //Behaviors
    public void updateProductId(ProductId productId){
        this.productId = productId;
    }

    public void updateDiscount(Discount discount){
        this.discount = discount;
    }

    //Attributes
    public ProductId productId() {
        return productId;
    }

    public Discount discount() {
        return discount;
    }
}
