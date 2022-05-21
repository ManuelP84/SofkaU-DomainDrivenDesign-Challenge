package com.sofkau.domainDrivenDesignChallenge.domain.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class CreateInvoice extends Command {
    private final StoreId storeId;
    private final InvoiceId invoiceId;
    private final OrderId   orderId;

    public CreateInvoice(StoreId storeId, InvoiceId invoiceId, OrderId orderId) {
        this.storeId = storeId;
        this.invoiceId = invoiceId;
        this.orderId = orderId;
    }

    //Getter methods

    public StoreId getStoreId() {
        return storeId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
