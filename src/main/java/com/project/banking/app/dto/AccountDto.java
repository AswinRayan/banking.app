package com.project.banking.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccountDto {
	public AccountDto() {
	}

	public AccountDto(long id, String accountHolderName, double balance) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountHolderNmae() {
		return accountHolderName;
	}

	public void setAccountHolderNmae(String accountHolderNmae) {
		this.accountHolderName = accountHolderNmae;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
	}
	@JsonProperty
	private long id;
	@JsonProperty
	private String accountHolderName;
	@JsonProperty
	private double balance;
}
