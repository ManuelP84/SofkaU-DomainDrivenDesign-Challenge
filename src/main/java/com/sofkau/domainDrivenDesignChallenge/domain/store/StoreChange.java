package com.sofkau.domainDrivenDesignChallenge.domain.store;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.*;

import java.util.HashSet;

public class StoreChange extends EventChange {

    public StoreChange(Store store) {

        apply((StoreCreated event) -> {
            store.name = event.getName();
            store.products = new HashSet<>();
            store.invoices = new HashSet<>();
        });

        apply((InvoiceCreated event) -> {
            store.invoices.add(new Invoice(
                    event.getInvoiceId(),
                    event.getOrderId()
            ));
        });

        apply((ProductCreated event) -> {
            store.products.add(new Product(
                    event.getProductId(),
                    event.getName(),
                    event.getPrice()
            ));
        });

        apply((NameUpdated event) -> {
            store.name = event.getName();
        });

        apply((InvoiceOrderIdUpdated event) -> {
            var invoice = store
                    .findInvoiceById(event.getInvoiceId())
                    .orElseThrow(() -> new IllegalArgumentException("Invoice was not found!"));
            invoice.updateOrderId(event.getOrderId());
        });

        apply((ProductNameUpdated event) -> {
            var product = store
                    .findProductById(event.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Product was not found!"));
            product.updateName(event.getName());
        });

        apply((ProductPriceUpdated event) -> {
            var product = store
                    .findProductById(event.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Product was not found!"));
            product.updatePrice(event.getPrice());
        });
    }
}
