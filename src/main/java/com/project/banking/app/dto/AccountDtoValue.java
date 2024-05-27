package com.project.banking.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDtoValue {
	@JsonProperty
	private String accountHolderName;
	@JsonProperty
	private double balance;
}
