package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.store.commands.CreateInvoice;
import com.sofkau.domainDrivenDesignChallenge.domain.store.commands.CreateProduct;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.InvoiceCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.ProductCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.store.events.StoreCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.InvoiceId;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.Price;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.OrderId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;
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
public class CreateProductUseCaseTest {

    private final String ROOTID = "1234567abcde";

    @InjectMocks
    private CreateProductUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createProductHappyPass() {

        //Arrange
        var command = new CreateProduct(
                StoreId.of(ROOTID),
                ProductId.of("1234"),
                new Name("Milk"),
                new Price(850.5)
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
        var event = (ProductCreated) events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getPrice().value(), event.getPrice().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

    private List<DomainEvent> history() {
        Name storeName = new Name("Walmart");
        var event = new StoreCreated(storeName);
        event.setAggregateRootId(ROOTID);
        return List.of(event);
    }
}
