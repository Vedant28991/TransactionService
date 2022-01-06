package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Transaction;
import com.springboot.repo.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public boolean transact(Integer bill) {
		
		
		
		return false;
	}

	@Override
	public boolean dotransaction(Transaction transaction) {
		
		Integer act=transaction.getAccountNumber();
		//Integer bal=500;
		Integer bal=transaction.getBalance();
		Integer bill=transaction.getBill();
		
		Integer curbal=bal-bill;
		
		if(curbal>=0) {
	   // transactionRepository.save(transaction);
		transactionRepository.deductFromAcccount(curbal,act);
		transaction.setBalance(curbal);
		System.out.println(curbal);
		transactionRepository.save(transaction);

		return true;
		}else
		return false;
	}

	
	
	
}
