package com.project.banking.app.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.banking.app.Exception.CustomException;
import com.project.banking.app.dto.AccountDto;
import com.project.banking.app.service.AccountService;
import com.project.banking.app.validate.RestApiRequest;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;
	private static final String CONTENT_TYPE = "application/json";

//	@RequestMapping(value = { "/create" }, method = RequestMethod.POST, consumes = { "application/json" }, produces = {
//			CONTENT_TYPE })
//	public @ResponseBody String createCustomer(final @RequestBody String requestData,
//			final @RequestHeader HttpHeaders paramHttpHeaders, final HttpServletRequest httpRequest,
//			final HttpServletResponse paramHttpResp)
//			throws SecurityOperationFailure, NoRecordFound, CustomerException, ParseException, FieldValidationFailure,
//			InvalidBufferStream, IOException, SocketClosedException, RoutingException {
//		byte[] responseBytes = null;
//		try (Session session = 
//
//				.getSession()) {
//			final Transaction txn = session.beginTransaction();
//			responseBytes = customers.createCustomer(requestData, paramHttpHeaders, httpRequest, paramHttpResp,
//					session);
//			CommonHibernateDAO.finalizeSession(session, txn);
//
//		}
//		return new String(responseBytes, StandardCharsets.UTF_8);
	@PostMapping(value = { "/createAccount" }, consumes = { CONTENT_TYPE }, produces = { CONTENT_TYPE })

	public @ResponseBody String addAccounts(@RequestBody String accountDto)
			throws JsonMappingException, JsonProcessingException {
		AccountDto dto = RestApiRequest.validateRequest(accountDto, AccountDto.class);

		byte[] responseByte = accountService.createAccounts(dto);
		return new String(responseByte, StandardCharsets.UTF_8);
	}

	// add account
	// @PostMapping("/createAccount")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) throws CustomException {

		AccountDto addedAccount = accountService.createAccount(accountDto);

		return new ResponseEntity<AccountDto>(addedAccount, HttpStatus.CREATED);

	}

//getAccount
	@GetMapping(value = { "/{id}" }, produces = { CONTENT_TYPE })
	public ResponseEntity<AccountDto> getAccountbyId(@PathVariable long id) {
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);

	}// deposit

	@PutMapping(value = { "/{id}/deposit" }, produces = { CONTENT_TYPE })
	public ResponseEntity<AccountDto> deposit(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}

//withdraw
	@PutMapping(value = { "/{id}/withdraw" }, produces = { CONTENT_TYPE })
	public ResponseEntity<AccountDto> withDraw(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}

	// get all accounts list
	@GetMapping(value = { "/getdetails" }, produces = { CONTENT_TYPE })
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		List<AccountDto> accountDetails = accountService.getAllAccount();
		return ResponseEntity.ok(accountDetails);
	}

	// delete accounts
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted Successfully");
	}
}
