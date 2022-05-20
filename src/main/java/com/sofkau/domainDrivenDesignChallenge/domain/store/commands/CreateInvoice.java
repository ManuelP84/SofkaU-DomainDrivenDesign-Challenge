package com.sofkau.domainDrivenDesignChallenge.domain.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class CreateInvoice extends Command {
    private final InvoiceId invoiceId;
    private final OrderId orderId;

    public CreateInvoice(InvoiceId invoiceId, OrderId orderId){
        this.invoiceId = invoiceId;
        this.orderId = orderId;
    }

    //Getter methods
    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
