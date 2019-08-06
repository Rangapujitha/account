package com.account.management.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.management.service.model.AccountEntity;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {
}
