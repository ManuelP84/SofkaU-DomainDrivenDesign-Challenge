package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.Cart;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.commands.CreateCart;

public class CreateCartUseCase extends UseCase<RequestCommand<CreateCart>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCart> createCartRequestCommand) {
        var command = createCartRequestCommand.getCommand();
        var cart = new Cart(command.getCartId(), command.getName());

        emit().onResponse(new ResponseEvents(cart.getUncommittedChanges()));
    }
}
