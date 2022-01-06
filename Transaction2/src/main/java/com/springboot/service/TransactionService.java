package com.springboot.service;

import com.springboot.entity.Transaction;

public interface TransactionService {

	boolean transact(Integer bill);

	boolean dotransaction(Transaction transaction);

	

}
