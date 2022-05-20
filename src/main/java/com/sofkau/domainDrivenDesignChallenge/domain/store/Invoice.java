package com.sofkau.domainDrivenDesignChallenge.domain.store;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class Invoice extends Entity<InvoiceId> {
    private OrderId orderId;

    public Invoice(InvoiceId entityId, OrderId orderId) {
        super(entityId);
        this.orderId = orderId;
    }

    // Methods
    public void updateOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    //Attributes
    public OrderId orderId() {
        return orderId;
    }
}
