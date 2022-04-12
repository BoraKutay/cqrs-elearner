package com.turkcell.elearner.application.features.accountTypes.commands.delete;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@Value
public class DeleteAccountTypeCommand {
	
	@TargetAggregateIdentifier
	private String accountTypeId;
}
