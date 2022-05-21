package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.store.Store;
import com.sofkau.domainDrivenDesignChallenge.domain.store.commands.CreateStore;
import com.sofkau.domainDrivenDesignChallenge.domain.user.User;

public class CreateStoreUseCase extends UseCase<RequestCommand<CreateStore>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateStore> createStoreRequestCommand) {
        var command = createStoreRequestCommand.getCommand();
        var store = new Store(command.getStoreId(), command.getName());

        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}

