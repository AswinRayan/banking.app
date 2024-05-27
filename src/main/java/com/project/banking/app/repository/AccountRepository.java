package com.project.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
