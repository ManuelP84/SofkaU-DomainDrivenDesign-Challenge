package com.sofkau.domainDrivenDesignChallenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.domainDrivenDesignChallenge.domain.user.User;
import com.sofkau.domainDrivenDesignChallenge.domain.user.commands.UpdateUserName;

public class UpdateUserNameUseCase extends UseCase<RequestCommand<UpdateUserName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateUserName> updateUserNameRequestCommand) {
        var command = updateUserNameRequestCommand.getCommand();
        var user = User.from(
                command.getUserId(),
                repository().getEventsBy(command.getUserId().value())
        );
        user.updateUserName(command.getName());

        emit().onResponse(new ResponseEvents(user.getUncommittedChanges()));
    }
}
