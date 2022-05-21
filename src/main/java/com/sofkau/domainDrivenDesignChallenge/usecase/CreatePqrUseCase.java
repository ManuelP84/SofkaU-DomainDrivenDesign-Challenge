package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.user.User;
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.CreatePqr;

public class CreatePqrUseCase extends UseCase<RequestCommand<CreatePqr>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreatePqr> createPqrRequestCommand) {
        var command = createPqrRequestCommand.getCommand();
        var user = User.from(
                command.getUserId(),
                repository().getEventsBy(command.getUserId().value())
        );
        user.createPqr(command.getPqrId(), command.getDescription());

        emit().onResponse(new ResponseEvents(user.getUncommittedChanges()));
    }
}
