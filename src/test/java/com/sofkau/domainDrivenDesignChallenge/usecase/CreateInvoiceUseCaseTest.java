package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.commands.CreateInvoice;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.InvoiceCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.StoreCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateInvoiceUseCaseTest {

    private final String ROOTID = "1234567abcde";

    @InjectMocks
    private CreateInvoiceUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createInvoiceHappyPass() {

        //Arrange
        var command = new CreateInvoice(
                StoreId.of(ROOTID),
                InvoiceId.of("1234"),
                OrderId.of("5678")
        );
        when(repository.getEventsBy(ROOTID)).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //Asserts
        var event = (InvoiceCreated) events.get(0);
        Assertions.assertEquals(command.getInvoiceId().value(), event.getInvoiceId().value());
        Assertions.assertEquals(command.getOrderId().value(), event.getOrderId().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

    private List<DomainEvent> history() {
        Name storeName = new Name("Walmart");
        var event = new StoreCreated(storeName);
        event.setAggregateRootId(ROOTID);
        return List.of(event);
    }
}
