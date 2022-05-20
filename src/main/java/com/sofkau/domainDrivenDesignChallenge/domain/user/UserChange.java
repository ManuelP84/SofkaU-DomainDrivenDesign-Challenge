package com.sofkau.domainDrivenDesignChallenge.domain.user;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.*;

import java.util.HashSet;

public class UserChange extends EventChange {
    public UserChange(User user) {

        apply((UserCreated event) -> {
            user.name = event.getName();
            user.pqrs = new HashSet<>();
            user.orders = new HashSet<>();
        });

        apply((PqrCreated event) ->{
            user.pqrs().add(new Pqr(
                    event.getPqrId(),
                    event.getDescription()
            ));
        });

        apply((OrderCreated event) -> {
            user.orders().add(new Order(
                    event.getOrderId(),
                    event.getDate(),
                    event.getCartId()
            ));
        });

        apply((UserNameUpdated event) -> {
            user.name = event.getName();
        });

        apply((PqrDescriptionUpdated event) -> {
            var pqr = user
                    .findPqrById(event.getPqrId())
                    .orElseThrow(() -> new IllegalArgumentException("Pqr was not found!"));
            pqr.updateDescription(event.getDescription());
        });

        apply((OrderDateUpdated event) -> {
            var order = user
                    .findOrderById(event.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Order was not found!"));
            order.updateDate(event.getDate());
        });

        apply((OrderCartIdUpdated event) ->{
            var order = user
                    .findOrderById(event.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Order was not found!"));
            order.updateCartId(event.getCartId());
        });
    }
}
