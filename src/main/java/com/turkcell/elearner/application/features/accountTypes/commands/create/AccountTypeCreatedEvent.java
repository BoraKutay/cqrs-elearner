package com.turkcell.elearner.application.features.accountTypes.commands.create;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class AccountTypeCreatedEvent {
	@TargetAggregateIdentifier
	private String accountTypeId;
	private String accountName;
	private double price;
	private String description;
}
