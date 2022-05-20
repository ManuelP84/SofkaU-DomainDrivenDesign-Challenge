package com.sofkau.domainDrivenDesignChallenge.domain.cart.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Discount;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class CreateOffer extends Command {
    private final OfferId   offerId;
    private final ProductId productId;
    private final Discount  discount;

    public CreateOffer(OfferId entityId, ProductId productId, Discount discount) {
        this.offerId = entityId;
        this.productId = productId;
        this.discount = discount;
    }

    //Getter methods
    public OfferId getOfferId() {
        return offerId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Discount getDiscount() {
        return discount;
    }
}
