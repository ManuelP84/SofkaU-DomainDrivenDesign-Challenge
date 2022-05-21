package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.InvoiceCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.OrderCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Date;
import com.sofkau.domainDrivenDesignChallenge.domain.values.CartId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotifyInvoiceProcessUseCaseTest {
    private final String ROOTID = "1234567abcde";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyInvoiceProcessTest(){
        var event = new OrderCreated(OrderId.of("1234"), new Date("02-09-2022"), CartId.of("2222"));
    event.setAggregateRootId(ROOTID);

    var useCase = new NotifyInvoiceProcessUseCase();

        //Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
        //        event
        //));
        
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var invoice = (InvoiceCreated)events.get(0);
        Assertions.assertEquals(event.getOrderId().value(),invoice.getOrderId().value());
    }
}
