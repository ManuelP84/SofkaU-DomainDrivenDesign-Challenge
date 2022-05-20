package com.sofkau.domainDrivenDesignChallenge.domain.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class OrderDateUpdated extends DomainEvent {
    private final OrderId orderId;
    private final Date    date;

    public OrderDateUpdated(OrderId entityId, Date date) {
        super("sofkaU.user.orderDateUpdated");
        this.orderId = entityId;
        this.date = date;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }
}
