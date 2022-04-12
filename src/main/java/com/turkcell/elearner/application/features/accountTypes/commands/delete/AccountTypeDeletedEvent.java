package com.turkcell.elearner.application.features.accountTypes.commands.delete;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class AccountTypeDeletedEvent {
	
	@TargetAggregateIdentifier
	private String accountTypeId;
}
