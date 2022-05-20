package com.sofkau.domainDrivenDesignChallenge.domain.cart.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Discount;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;

public class OfferDiscountUpdated extends DomainEvent {
    private final OfferId offerId;
    private final Discount discount;

    public OfferDiscountUpdated(OfferId entityId, Discount discount) {
        super("sofkaU.cart.offerDiscountUpdated");
        this.offerId = entityId;
        this.discount = discount;
    }

    //Getter methods
    public OfferId getOfferId() {
        return offerId;
    }

    public Discount getDiscount() {
        return discount;
    }
}
