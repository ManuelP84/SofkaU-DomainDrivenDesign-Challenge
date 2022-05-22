package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.Store;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.OrderCreated;


public class NotifyInvoiceProcessUseCase extends UseCase<TriggeredEvent<OrderCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<OrderCreated> orderCreatedTriggeredEvent) {
        var event = orderCreatedTriggeredEvent.getDomainEvent();
        var store = Store.from(
                StoreId.of(event.aggregateRootId()),
                this.retrieveEvents()
        );
        store.createInvoice(InvoiceId.of("1234"), event.getOrderId());

        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}
