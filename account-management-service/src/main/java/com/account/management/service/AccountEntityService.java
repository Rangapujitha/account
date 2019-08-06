package com.account.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.account.management.service.model.AccountEntity;
import com.account.management.service.repo.AccountEntityRepository;

@Component
public class AccountEntityService {
	@Autowired
	AccountEntityRepository repository;

	public List<AccountEntity> getAllAccounts() {
		List<AccountEntity> accountList = repository.findAll();

		if (accountList.size() > 0) {
			return accountList;
		}
		return new ArrayList<AccountEntity>();

	}

	public AccountEntity getAccountById(Long id) throws AccountNotFoundException {
		Optional<AccountEntity> account = repository.findById(id);

		if (account.isPresent()) {
			return account.get();
		} else {
			throw new AccountNotFoundException(String.valueOf(id));
		}
	}

	public AccountEntity createOrUpdateAccount(AccountEntity entity) throws AccountNotFoundException {
		Optional<AccountEntity> account = repository.findById(entity.getId());

		if (account.isPresent()) {
			AccountEntity newEntity = account.get();
			newEntity.setAccount_no(entity.getAccount_no());
			newEntity.setAmount(entity.getAmount());
			newEntity.setBaseCurrency(entity.getBaseCurrency());
			newEntity.setModifiedDate(new Date());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			AccountEntity newEntity = new AccountEntity();
			newEntity.setAccount_no(entity.getAccount_no());
			newEntity.setAmount(entity.getAmount());
			newEntity.setBaseCurrency(entity.getBaseCurrency());
			newEntity.setCreatedDate(new Date());
			newEntity.setModifiedDate(new Date());
			
			entity = repository.save(newEntity);

			return entity;
		}
	}

	public void deleteAccountById(Long id) throws AccountNotFoundException {
		Optional<AccountEntity> account = repository.findById(id);

		if (account.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new AccountNotFoundException(String.valueOf(id));
		}
	}

}
