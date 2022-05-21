package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.store.Store;
import com.sofkau.domainDrivenDesignChallenge.domain.store.commands.CreateInvoice;

public class CreateInvoiceUseCase extends UseCase<RequestCommand<CreateInvoice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateInvoice> createInvoiceRequestCommand) {
        var comand = createInvoiceRequestCommand.getCommand();
        var store = Store.from(
                comand.getStoreId(),
                repository().getEventsBy(comand.getStoreId().value())
        );
        store.createInvoice(
                comand.getInvoiceId(),
                comand.getOrderId()
        );
        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}