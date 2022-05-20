package com.sofkau.domainDrivenDesignChallenge.domain.cart;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.*;

import java.util.HashSet;

public class CartChange extends EventChange {
    public CartChange(Cart cart){
        apply((CartCreated event) -> {
            cart.name = event.getName();
            cart.items = new HashSet<>();
            cart.offers = new HashSet<>();
        });

        apply((ItemCreated event) ->{
            cart.items.add(new Item(
                    event.getItemId(),
                    event.getProductId(),
                    event.getQuantity()
            ));
        });

        apply((OfferCreated event) -> {
            cart.offers.add(new Offer(
                    event.getOfferId(),
                    event.getProductId(),
                    event.getDiscount()
            ));
        });

        apply((ItemProductIdUpdated event) -> {
            var item = cart
                    .findItemById(event.getItemId())
                    .orElseThrow(() -> new IllegalArgumentException("Item was not found!"));
            item.updateProductId(event.getProductId());
        });

        apply((ItemQuantityUpdated event) -> {
            var item = cart
                    .findItemById(event.getItemId())
                    .orElseThrow(() -> new IllegalArgumentException("Item was not found!"));
            item.updateQuantity(event.getQuantity());
        });

        apply((OfferProductIdUpdated event) -> {
            var offer = cart
                    .findOfferById(event.getOfferId())
                    .orElseThrow(() -> new IllegalArgumentException("Offer was not found!"));
            offer.updateProductId(event.getProductId());
        });

        apply((OfferDiscountUpdated event) -> {
            var offer = cart
                    .findOfferById(event.getOfferId())
                    .orElseThrow(() -> new IllegalArgumentException("Offer was not found!"));
            offer.updateDiscount(event.getDiscount());
        });
    }
}
