package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Transaction;
import com.springboot.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("")
	public ResponseEntity<String> transact(@RequestParam Integer bill){
		
		
		
		boolean IsDone=transactionService.transact(bill);
		
		return null;
	}
	
	@PostMapping("")
	public ResponseEntity<String> transaction(@RequestBody Transaction transaction){
		
		boolean done=transactionService.dotransaction(transaction);
		if(done) {
		return new ResponseEntity<String>("Transaction Successful",HttpStatus.ACCEPTED);
		}else
		return new ResponseEntity<String>("Something went wrong",HttpStatus.BAD_REQUEST);
		
	}
	
}
