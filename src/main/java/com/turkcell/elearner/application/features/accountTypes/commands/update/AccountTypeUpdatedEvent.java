package com.turkcell.elearner.application.features.accountTypes.commands.update;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class AccountTypeUpdatedEvent {
	@TargetAggregateIdentifier
	private String accountTypeId;
	private String accountName;
	private double price;
	private String description;
}
