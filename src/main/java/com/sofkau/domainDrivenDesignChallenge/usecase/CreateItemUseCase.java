package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.Cart;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.commands.CreateItem;

public class CreateItemUseCase extends UseCase<RequestCommand<CreateItem>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateItem> createItemRequestCommand) {
        var command = createItemRequestCommand.getCommand();
        var cart = Cart.from(
                command.getCartId(),
                repository().getEventsBy(command.getCartId().value())
        );
        cart.createItem(
                command.getItemId(),
                command.getProductId(),
                command.getQuantity()
        );

        emit().onResponse(new ResponseEvents(cart.getUncommittedChanges()));
    }
}
