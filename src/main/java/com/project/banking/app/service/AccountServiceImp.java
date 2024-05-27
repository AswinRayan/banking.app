package com.project.banking.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.banking.app.dto.AccountDto;
import com.project.banking.app.entity.Account;
import com.project.banking.app.mapper.AccountMapper;
import com.project.banking.app.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDto);
		accountRepository.save(account);

		return AccountMapper.mapToAccountDto(account);
	}

	public byte[] createAccounts(AccountDto accountDto) throws JsonProcessingException {
		// TODO Auto-generated method stub
		byte[] responseBytes = null;
		ObjectMapper objectMapper = new ObjectMapper();
		Account account = AccountMapper.mapToAccount(accountDto);
		accountRepository.save(account);
		AccountDto accountDv = AccountMapper.mapToAccountDto(account);
		System.out.println(accountDv.toString());
		responseBytes = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(accountDv).getBytes();
		System.out.println(responseBytes.toString());
		return responseBytes;

	}

	@Override
	public AccountDto getAccountById(long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));

		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(long id, double amount) {
		// TODO Auto-generated method stub
		double total;
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		// AccountDto dto = AccountMapper.mapToAccountDto(account);
		if (account.getBalance() < amount) {
			throw new RuntimeException("insuffient amount");
		} else {
			total = account.getBalance() - amount;
		}

		account.setBalance(total);
		Account savedAmount = accountRepository.save(account);
		// Account updateAccountDetails = AccountMapper.mapToAccount(dto);
		// accountRepository.save(updateAccountDetails);
		return AccountMapper.mapToAccountDto(savedAmount);
	}

	@Override
	public AccountDto withDraw(long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow();
		double updateAmount = account.getBalance() - amount;
		account.setBalance(updateAmount);
		accountRepository.save(account);
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public List<AccountDto> getAllAccount() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

	}

	@Override
	public void deleteAccount(long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		accountRepository.deleteById(id);

	}

}
