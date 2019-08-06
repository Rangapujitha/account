package com.account.management.service.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.management.service.AccountEntityService;
import com.account.management.service.model.AccountEntity;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/accounts")
public class AccountEnitityController {
	@Autowired
	AccountEntityService service;
	
	Logger log = LogManager.getLogger(AccountEnitityController.class);

	@GetMapping
	public ResponseEntity<List<AccountEntity>> getAllAccounts() {
		List<AccountEntity> list = service.getAllAccounts();

		return new ResponseEntity<List<AccountEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountEntity> getAccountById(@PathVariable("id") Long id) throws AccountNotFoundException {
		AccountEntity entity = service.getAccountById(id);
		return new ResponseEntity<AccountEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AccountEntity> createOrUpdateAccount(@RequestBody String account)
			throws AccountNotFoundException, JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		AccountEntity entity = mapper.readValue(account, AccountEntity.class);
		log.info("Account for create or update "+entity);
		AccountEntity updated = service.createOrUpdateAccount(entity);
		return new ResponseEntity<AccountEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteAccountById(@PathVariable("id") Long id) throws AccountNotFoundException {
		service.deleteAccountById(id);
		return HttpStatus.FORBIDDEN;
	}
	
}
