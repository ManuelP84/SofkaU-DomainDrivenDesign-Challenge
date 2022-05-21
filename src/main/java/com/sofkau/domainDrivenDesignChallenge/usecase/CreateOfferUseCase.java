package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.Cart;
import com.sofkau.domainDrivenDesignChallenge.domain.cart.commands.CreateOffer;

public class CreateOfferUseCase extends UseCase<RequestCommand<CreateOffer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateOffer> createOfferRequestCommand) {
        var command = createOfferRequestCommand.getCommand();
        var cart = Cart.from(
                command.getCartId(),
                repository().getEventsBy(command.getCartId().value())
        );
        cart.createOffer(
                command.getOfferId(),
                command.getProductId(),
                command.getDiscount()
        );

        emit().onResponse(new ResponseEvents(cart.getUncommittedChanges()));
    }
}
