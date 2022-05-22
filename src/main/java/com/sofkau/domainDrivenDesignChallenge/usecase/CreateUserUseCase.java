package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.user.User;
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.CreateUser;

public class CreateUserUseCase extends UseCase<RequestCommand<CreateUser>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateUser> createUserRequestCommand) {
        var command = createUserRequestCommand.getCommand();
        var user = new User(
                command.getUserId(),
                command.getName()
        );

        emit().onResponse(new ResponseEvents(user.getUncommittedChanges()));
    }
}
