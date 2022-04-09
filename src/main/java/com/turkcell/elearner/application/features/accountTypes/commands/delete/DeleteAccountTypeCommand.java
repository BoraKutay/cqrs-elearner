package com.turkcell.elearner.application.features.accountTypes.commands.delete;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.turkcell.elearner.application.features.accountTypes.commands.create.CreateAccountTypeCommand;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteAccountTypeCommand {
	@TargetAggregateIdentifier
	private String accountTypeId;
}
