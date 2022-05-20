package com.sofkau.domainDrivenDesignChallenge.domain.cart;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.events.*;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Discount;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.ItemId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.OfferId;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.values.Quantity;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cart extends AggregateEvent<CartId> {
    protected Name       name;
    protected Set<Item>  items;
    protected Set<Offer> offers;

    public Cart(CartId entityId, Name name) {
        super(entityId);
        appendChange(new CartCreated(name)).apply();
    }

    private Cart(CartId entityId) {
        super(entityId);
        subscribe(new CartChange(this));
    }

    public static Cart from(CartId entityId, List<DomainEvent> events) {
        var cart = new Cart(entityId);
        events.forEach(cart::applyEvent);
        return cart;
    }

    public void createItem(ItemId entityId, ProductId productId, Quantity quantity) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(productId);
        Objects.requireNonNull(quantity);
        appendChange(new ItemCreated(entityId, productId, quantity)).apply();
    }

    public void createOffer(OfferId entityId, ProductId productId, Discount discount) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(productId);
        Objects.requireNonNull(discount);
        appendChange(new OfferCreated(entityId, productId, discount)).apply();
    }

    public void updateName(Name name) {
        Objects.requireNonNull(name);
        appendChange(new NameUpdated(name)).apply();
    }

    public void updateItemProductId(ItemId entityId, ProductId productId) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(productId);
        appendChange(new ItemProductIdUpdated(entityId, productId)).apply();
    }

    public void updateItemQuantity(ItemId entityId, Quantity quantity) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(quantity);
        appendChange(new ItemQuantityUpdated(entityId, quantity)).apply();
    }

    public void updateOfferProductId(OfferId entityId, ProductId productId) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(productId);
        appendChange(new OfferProductIdUpdated(entityId, productId)).apply();
    }

    public void updateOfferDiscount(OfferId entityId, Discount discount) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(discount);
        appendChange(new OfferDiscountUpdated(entityId, discount)).apply();
    }

    //Methods
    protected Optional<Item> findItemById(ItemId entityId) {
        return items()
                .stream()
                .filter((item) -> item.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Offer> findOfferById(OfferId entityId) {
        return offers()
                .stream()
                .filter((offer) -> offer.identity().equals(entityId))
                .findFirst();
    }

    //Attributes
    public Name name() {
        return name;
    }

    public Set<Item> items() {
        return items;
    }

    public Set<Offer> offers() {
        return offers;
    }
}
