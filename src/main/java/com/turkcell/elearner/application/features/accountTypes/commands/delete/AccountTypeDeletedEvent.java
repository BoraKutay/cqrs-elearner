package com.turkcell.elearner.application.features.accountTypes.commands.delete;

import lombok.Data;

@Data
public class AccountTypeDeletedEvent {
	private String accountTypeId;
}
