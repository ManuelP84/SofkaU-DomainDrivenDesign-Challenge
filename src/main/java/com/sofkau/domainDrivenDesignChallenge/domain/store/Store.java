package com.sofkau.domainDrivenDesignChallenge.domain.store;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.*;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.Price;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Store extends AggregateEvent<StoreId> {
    protected Name         name;
    protected Set<Product> products;
    protected Set<Invoice> invoices;

    public Store(StoreId entityId, Name name) {
        super(entityId);
        appendChange(new StoreCreated(name)).apply();
    }

    private Store(StoreId entityId) {
        super(entityId);
        subscribe(new StoreChange(this));
    }

    public static Store from(StoreId entityId, List<DomainEvent> events) {
        var store = new Store(entityId);
        events.forEach(store::applyEvent);
        return store;
    }

    public void createInvoice(InvoiceId entityId, OrderId orderId) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(orderId);
        appendChange(new InvoiceCreated(entityId, orderId)).apply();
    }

    public void createProduct(ProductId entityId, Name name, Price price) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        appendChange(new ProductCreated(entityId, name, price)).apply();
    }

    public void updateName(Name name) {
        Objects.requireNonNull(name);
        appendChange(new NameUpdated(name)).apply();
    }

    public void updateInvoiceOrderId(InvoiceId entityId, OrderId orderId) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(orderId);
        appendChange(new InvoiceOrderIdUpdated(entityId, orderId)).apply();
    }

    public void updateProductName(ProductId entityId, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        appendChange(new ProductNameUpdated(entityId, name)).apply();
    }

    public void updateProductPrice(ProductId entityId, Price price) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(price);
        appendChange(new ProductPriceUpdated(entityId, price)).apply();
    }

    //Methods
    protected Optional<Invoice> findInvoiceById(InvoiceId entityId) {
        return invoices()
                .stream()
                .filter((invoice) -> invoice.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Product> findProductById(ProductId entityId) {
        return products()
                .stream()
                .filter((product) -> product.identity().equals(entityId))
                .findFirst();
    }

    // Attributes
    public Name name() {
        return name;
    }

    public Set<Product> products() {
        return products;
    }

    public Set<Invoice> invoices() {
        return invoices;
    }
}
