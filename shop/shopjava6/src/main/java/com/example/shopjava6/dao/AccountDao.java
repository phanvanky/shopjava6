package com.example.shopjava6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopjava6.entity.Account;

public interface AccountDao extends JpaRepository<Account, String> {

}
