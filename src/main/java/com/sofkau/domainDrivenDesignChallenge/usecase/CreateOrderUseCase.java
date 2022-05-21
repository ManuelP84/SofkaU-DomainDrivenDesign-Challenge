package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.user.User;
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.CreateOrder;

public class CreateOrderUseCase extends UseCase<RequestCommand<CreateOrder>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateOrder> createOrderRequestCommand) {
        var command = createOrderRequestCommand.getCommand();
        var user = User.from(
                command.getUserId(),
                repository().getEventsBy(command.getUserId().value())
        );
        user.createOrder(
                command.getOrderId(),
                command.getDate(),
                command.getCartId()
        );

        emit().onResponse(new ResponseEvents(user.getUncommittedChanges()));
    }
}
