package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.store.Store;
import com.sofkau.domainDrivenDesignChallenge.domain.store.commands.CreateProduct;

public class CreateProductUseCase extends UseCase<RequestCommand<CreateProduct>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateProduct> createProductRequestCommand) {
        var command = createProductRequestCommand.getCommand();
        var store = Store.from(
                command.getStoreId(),
                repository().getEventsBy(command.getStoreId().value())
        );
        store.createProduct(
                command.getProductId(),
                command.getName(),
                command.getPrice()
        );
        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}
