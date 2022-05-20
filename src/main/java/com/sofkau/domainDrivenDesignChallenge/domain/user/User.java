package com.sofkau.domainDrivenDesignChallenge.domain.user;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.*;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Description;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.PqrId;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class User extends AggregateEvent<UserId> {
    protected Name     name;
    protected Set<Pqr> Pqrs;
    protected Set<Order> orders;

    public User(UserId entityId, Name name) {
        super(entityId);
        appendChange(new UserCreated(name)).apply();
    }

    private User(UserId entityId){
        super(entityId);
        subscribe(new UserChange(this));
    }

    public static User from(UserId userId, List<DomainEvent> events){
        var user = new User(userId);
        events.forEach(user::applyEvent);
        return user;
    }

    public void createPqr(PqrId entityId, Description description) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(description);
        appendChange(new PqrCreated(entityId, description)).apply();
    }

    public void createOrder(OrderId entityId, Date date, CartId cartId){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(date);
        Objects.requireNonNull(cartId);
        appendChange(new OrderCreated(entityId, date, cartId)).apply();
    }

    public void updateUserName(Name name){
        Objects.requireNonNull(name);
        appendChange(new UserNameUpdated(name)).apply();
    }

    public void updatePqrDescription(PqrId entityId, Description description){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(description);
        appendChange(new PqrDescriptionUpdated(entityId, description)).apply();
    }

    public void updateOrderDate(OrderId entityId, Date date){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(date);
        appendChange(new OrderDateUpdated(entityId, date)).apply();
    }

    public void updateOrderCartId(OrderId entityId, CartId cartId){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(cartId);
        appendChange(new OrderCartIdUpdated(entityId, cartId)).apply();
    }

    //Methods
    protected Optional<Order> findOrderById(OrderId entityId){
        return orders()
                .stream()
                .filter((order) -> order.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Pqr> findPqrById(PqrId entityId){
        return pqrs()
                .stream()
                .filter((pqr) -> pqr.identity().equals(entityId))
                .findFirst();
    }

    //Attributes
    public Name name() {
        return name;
    }

    public Set<Pqr> pqrs() {
        return Pqrs;
    }

    public Set<Order> orders() {
        return orders;
    }
}
