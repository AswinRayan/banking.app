package com.project.banking.app.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.banking.app.dto.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(long id);

	AccountDto deposit(long id, double amount);

	AccountDto withDraw(long id, double amount);

	List<AccountDto> getAllAccount();

	void deleteAccount(long id);

	public byte[] createAccounts(AccountDto accountDto) throws JsonProcessingException;
}
