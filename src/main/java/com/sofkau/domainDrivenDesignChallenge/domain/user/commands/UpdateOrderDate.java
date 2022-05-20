package com.sofkau.domainDrivenDesignChallenge.domain.user.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

public class UpdateOrderDate extends Command {
    private final OrderId orderId;
    private final Date    date;

    public UpdateOrderDate(OrderId entityId, Date date) {
        this.orderId = entityId;
        this.date = date;
    }

    // Getter methods
    public OrderId getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }
}
