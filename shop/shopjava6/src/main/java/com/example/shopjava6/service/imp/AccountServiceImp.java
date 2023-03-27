package com.example.shopjava6.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopjava6.dao.AccountDao;
import com.example.shopjava6.entity.Account;
import com.example.shopjava6.service.AccountService;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountDao dao;

	@Override
	public Account findById(String username) {
		return dao.findById(username).get();
	}
	
	
}
