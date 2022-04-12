package com.turkcell.elearner.application.features.accountTypes.commands.delete;


import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;



@Aggregate
public class DeleteAccountTypeAggreagate {
	
	@AggregateIdentifier
	private String accountTypeId;


		
	@CommandHandler
	public DeleteAccountTypeAggreagate(DeleteAccountTypeCommand deleteAccountTypeCommand) {
		//business kodları
		
		System.out.println("commandid aggregate"+ deleteAccountTypeCommand.getAccountTypeId());
		
		AccountTypeDeletedEvent accountTypeDeletedEvent = new AccountTypeDeletedEvent();

		BeanUtils.copyProperties(deleteAccountTypeCommand, accountTypeDeletedEvent);
		System.out.println("commandid deleted event"+ accountTypeDeletedEvent.getAccountTypeId());
		AggregateLifecycle.apply(accountTypeDeletedEvent);
		System.out.println("after apply commandid deleted event"+ accountTypeDeletedEvent.getAccountTypeId());
	}
	
	@EventSourcingHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		//event sourcing code 
		System.out.println("sourcing " + accountTypeDeletedEvent.getAccountTypeId());
		this.accountTypeId = accountTypeDeletedEvent.getAccountTypeId();


	}
	
}
