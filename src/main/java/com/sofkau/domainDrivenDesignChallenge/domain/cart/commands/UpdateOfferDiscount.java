package com.sofkau.domainDrivenDesignChallenge.domain.cart.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class UpdateOfferDiscount extends Command {
    private final OfferId   offerId;
    private final ProductId productId;

    public UpdateOfferDiscount(OfferId entityId, ProductId productId) {
        this.offerId = entityId;
        this.productId = productId;
    }

    //Getter methods
    public OfferId getOfferId() {
        return offerId;
    }

    public ProductId getProductId() {
        return productId;
    }
}
