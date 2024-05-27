package com.project.banking.app.mapper;

import com.project.banking.app.dto.AccountDto;
import com.project.banking.app.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.getId(), accountDto.getAccountHolderNmae(), accountDto.getBalance());
		return account;

	}

	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountdto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
		return accountdto;
	}

}
