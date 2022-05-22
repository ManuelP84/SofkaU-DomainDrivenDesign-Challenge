package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.CreatePqr;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.PqrCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.events.UserCreated;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.Description;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.PqrId;
import com.sofkau.domainDrivenDesignChallenge.domain.user.values.UserId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
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
public class CreatePqrUseCaseTest {

    private final String ROOTID = "1234abcd";

    @InjectMocks
    private CreatePqrUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createOrderHappyPass() {

        //arrange
        var command = new CreatePqr(
                UserId.of(ROOTID),
                PqrId.of("12345"),
                new Description("This is a complain that must contain at least 20 characters")
        );

        when(repository.getEventsBy(ROOTID)).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went bad!"))
                .getDomainEvents();

        //asserts
        var event = (PqrCreated) events.get(0);
        Assertions.assertEquals(command.getDescription().value(), event.getDescription().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

    private List<DomainEvent> history() {
        var event = new UserCreated(
                new Name("Manuel Pineda")
        );
        event.setAggregateRootId(ROOTID);
        return List.of(event);
    }
}
