package com.sofkau.domainDrivenDesignChallenge.domain.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class InvoiceCreated extends DomainEvent {
    private final InvoiceId invoiceId;
    private final OrderId   orderId;

    public InvoiceCreated(InvoiceId entityId, OrderId orderId) {
        super("sofkaU.store.invoiceCreated");
        this.invoiceId = entityId;
        this.orderId = orderId;
    }

    // Getter methods
    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
