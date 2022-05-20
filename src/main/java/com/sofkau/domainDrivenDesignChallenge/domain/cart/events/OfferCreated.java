package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Discount;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class OfferCreated extends DomainEvent {
    private final OfferId offerId;
    private final ProductId productId;
    private final Discount discount;

    public OfferCreated(OfferId entityId, ProductId productId, Discount discount) {
        super("sofkaU.cart.offerCreated");
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
