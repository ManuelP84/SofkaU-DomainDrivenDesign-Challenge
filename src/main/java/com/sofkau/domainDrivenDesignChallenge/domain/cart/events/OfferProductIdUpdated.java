package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class OfferProductIdUpdated extends DomainEvent {
    private final OfferId   offerId;
    private final ProductId productId;

    public OfferProductIdUpdated(OfferId entityId, ProductId productId) {
        super("sofkaU.cart.offerProductIdUpdated");
        this.offerId = entityId;
        this.productId = productId;
    }

    // Getter methods
    public OfferId getOfferId() {
        return offerId;
    }

    public ProductId getProductId() {
        return productId;
    }
}
