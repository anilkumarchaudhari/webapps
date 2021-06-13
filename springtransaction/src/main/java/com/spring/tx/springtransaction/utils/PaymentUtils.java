package com.spring.tx.springtransaction.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.spring.tx.springtransaction.exceptions.InsufficientAmountException;

//@Component
public class PaymentUtils {
     private static Map<String,Double> map = new HashMap<>();
      
		/*
		 * @PostConstruct public void initializeAccount() { map.put("acc1", 25000.0);
		 * map.put("acc2", 12000.0); map.put("acc3", 1000.0); map.put("acc4", 2000.0);
		 * 
		 * }
		 * 
		 */
     
     static {
    	 map.put("acc1", 25000.0);
     	map.put("acc2", 12000.0);
     	map.put("acc3", 1000.0);
     	map.put("acc4", 2000.0);
     }
    
    public static boolean validateCreditLimit(String account ,Double paidAmount) {
    	if(paidAmount> map.get(account)) {
    		System.out.println("inside if ");
    		throw new InsufficientAmountException("Insufficient fund ...!");
    	}else
    	  return true;
    }
}
