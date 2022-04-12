package com.turkcell.elearner.application.features.accountTypes.commands.create;
//createAccountType'in manageri gibi düşün

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turkcell.elearner.application.features.accountTypes.commands.delete.AccountTypeDeletedEvent;
import com.turkcell.elearner.application.features.accountTypes.commands.update.AccountTypeUpdatedEvent;
import com.turkcell.elearner.domain.AccountType;
import com.turkcell.elearner.persistence.AccountTypeRepository;


@Component
public class AccountTypeEventsHandler {
	
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public AccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@EventHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		
		AccountType accountType = new AccountType();
		
		BeanUtils.copyProperties(accountTypeCreatedEvent, accountType);
		
		this.accountTypeRepository.save(accountType);
	}
	
	@EventHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		this.accountTypeRepository.deleteById(accountTypeDeletedEvent.getAccountTypeId());	
	}
	
	@EventHandler
	public void on(AccountTypeUpdatedEvent accountTypeUpdatedEvent) {
        
		AccountType accountType = new AccountType();

        accountType.setAccountTypeId(accountTypeUpdatedEvent.getAccountTypeId());
        accountType.setAccountName(accountTypeUpdatedEvent.getAccountName());
        accountType.setPrice(accountTypeUpdatedEvent.getPrice());
        accountType.setDescription(accountTypeUpdatedEvent.getDescription());

        this.accountTypeRepository.save(accountType);			
	}
	
}
